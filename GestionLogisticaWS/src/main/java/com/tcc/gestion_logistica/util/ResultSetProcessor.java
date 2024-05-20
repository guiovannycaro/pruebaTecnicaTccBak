package com.tcc.gestion_logistica.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetProcessor {
	  public void process(ResultSet resultSet) throws SQLException;
}
