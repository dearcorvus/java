package com.lijian.mvcapp.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.lijian.mvcapp.db.JdbcUtils;

class JdbcUtilsTest {

	@Test
	void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
