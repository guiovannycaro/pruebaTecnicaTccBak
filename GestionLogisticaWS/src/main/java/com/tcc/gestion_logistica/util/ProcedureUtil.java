package com.tcc.gestion_logistica.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import oracle.jdbc.OracleTypes;

public class ProcedureUtil {
	private ProcedureUtil() {
    }
	
	  protected static final Log log = LogFactory.getLog(ProcedureUtil.class);
	  
	  
	  public static void executeUpdateGestion(String procedureName, String[] parameters) throws SQLException {
	        executeSelectGestion(procedureName, parameters, null);
	    }

	    public static void executeSelectGestion(String procedureName, String[] parameters,
	            ResultSetProcessor resultSetProcessor) throws SQLException {
	        try (Connection connection = ConnectionFactory.connectToGestionOra()) {
	            execute(connection, "SCH_CN", procedureName, parameters, resultSetProcessor);
	        }
	    }
	    
	    private static void execute(Connection connection, String schemaName, String procedureName, String[] parameters,
	            ResultSetProcessor resultSetProcessor) throws SQLException {
	        String sentence = getSentence(schemaName, procedureName, parameters, resultSetProcessor != null);
	        log.info(sentence);
	        try (CallableStatement callableStatement = connection.prepareCall(sentence);) {
	            for (int i = 0; i < parameters.length; i++) {
	                callableStatement.setString(i + 1, parameters[i]);
	            }
	            if (resultSetProcessor != null) {
	                int resultIndex = parameters.length + 1;
	                callableStatement.registerOutParameter(resultIndex, OracleTypes.CURSOR);
	                callableStatement.executeQuery();
	                try (ResultSet resultSet = (ResultSet) callableStatement.getObject(resultIndex)) {
	                    resultSetProcessor.process(resultSet);
	                }
	            } else {
	                callableStatement.executeQuery();
	            }
	        }
	    }
	    
	    private static String getSentence(String schemaName, String procedureName, String[] parameters,
	            boolean returnsResultSet) {
	        int numQuestionMarks = parameters.length + (returnsResultSet ? 1 : 0);
	        String[] questionMarkArray = new String[numQuestionMarks];
	        Arrays.fill(questionMarkArray, "?");
	        String questionMarks = String.join(",", questionMarkArray);
	        return String.format("{ call %s.%s(%s) }", schemaName, procedureName, questionMarks);
	    }
	   
	
}
