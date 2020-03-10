package com.lijian.mvcapp.db;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
	
	/**
	 * ጷ��B�ӵķ���
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
	 *����Դ��ʼ�������o�B���a���e�� 
	 *�����hֻ�ܱ���ʼ��һ�Σ����������Z���]���e�` �������YԴ
	 */
	static {
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
