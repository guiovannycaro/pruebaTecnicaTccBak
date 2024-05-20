package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "User", description = "Esta clase representa la informacion del Usuario a Logear")
public class User {
	
	@ApiModelProperty(value = "username", required = true, dataType = "String", example = "00000000", position = 1)
String username;
	@ApiModelProperty(value = "password", required = true, dataType = "String", example = "00000000", position = 1)
String password;

public User() {
}

public User(String username, String password) {
	this.username = username;
	this.password = password;
}


public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + "]";
}




}
