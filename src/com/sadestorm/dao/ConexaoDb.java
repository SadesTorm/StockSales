package com.sadestorm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDb {

	// metodo estabelece conexao com o banco de dados
	public static Connection conector() {
		java.sql.Connection conexao = null;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dbstocksaleshl";
		String user = "root";
		String password = "";

		try {

			conexao = DriverManager.getConnection(url, user, password);
			return conexao;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
