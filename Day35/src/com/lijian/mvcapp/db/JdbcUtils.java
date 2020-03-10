package com.lijian.mvcapp.db;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
	
	/**
	 * 釋放連接的方法
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	/**
	 *數據源初始化放在靜態代碼包裡面 
	 *數據遠只能被初始化一次，創建多個語法沒有錯誤 會佔用資源
	 */
	static {
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
