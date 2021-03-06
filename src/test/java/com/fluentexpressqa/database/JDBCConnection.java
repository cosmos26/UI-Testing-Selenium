package com.fluentexpressqa.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class JDBCConnection {

	String msdbUrl = "jdbc:sqlserver://fluent-express-test.database.windows.net:1433";
	String msdbUsername = "l7yReqQ2R7ZmSQnoE906yv7ViEZj39@fluent-express-test";
	String msdbPassword = "HNEvLdHdsyyFKuxKQ9Z2w6cY6efktar";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String str = "jdbc:sqlserver://fluent-express-test.database.windows.net:1433;database=fluent-express-test;user=l7yReqQ2R7ZmSQnoE906yv7ViEZj39@fluent-express-test;password=HNEvLdHdsyyFKuxKQ9Z2w6cY6efkta;";

	@Test
	public void msSqlJDBC() throws SQLException, ClassNotFoundException {
		//Class.forName(driver);
		Connection connection = DriverManager.getConnection(str);
		//Connection connection = DriverManager.getConnection(Configura, user, password)
		// Statement statement = connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery("select * from countries");
		// RESULTSET methods
		// next() -> moves to next row
		// getObject(colName/index) -> read data from column
		// last() -> goes to last row
		// frist() ->goes to first row
		// getRow() ->current row number
		// beforeFirst() -> goes to row 0
		// afterLast() ->goes to after last row
		// absolute() -> jumps to specific row

		// while (resultSet.next()) {
		// System.out.println(resultSet.getString(1) + "-" +
		// resultSet.getString("country_name") + "-"
		// + resultSet.getInt("region_id"));
		// }
		// resultSet.next();
		// System.out.println(resultSet.getRow());
		// resultSet.previous();
		// resultSet.first();
		// resultSet.last();
		// System.out.println(resultSet.getRow());

		// find out how many records in the resultSet
		resultSet.last();
		int rowsCount = resultSet.getRow();
		System.out.println("Number of Rows: " + rowsCount);

		resultSet.beforeFirst();
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "-" + resultSet.getString("country_name") + "-"
					+ resultSet.getInt("region_id"));
		}

		resultSet.close();
		statement.close();
		connection.close();

	}

	// @Test
	public void jdbcMetadata() throws SQLException {
		Connection connection = DriverManager.getConnection(msdbUrl, msdbUsername, msdbPassword);
		// Statement statement = connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select employee_id, last_name, job_id, salary from employees";
		ResultSet resultSet = statement.executeQuery(sql);
		// Database metadata
		DatabaseMetaData dbMetadata = connection.getMetaData();
		System.out.println("User: " + dbMetadata.getUserName());
		System.out.println("Database type: " + dbMetadata.getDatabaseProductName());
		// ResultSet metadata
		ResultSetMetaData rsMetadata = resultSet.getMetaData();
		System.out.println("Columns count: " + rsMetadata.getColumnCount());
		System.out.println(rsMetadata.getColumnName(1));
		// print all column names using a loop
		for (int i = 1; i <= rsMetadata.getColumnCount(); i++) {
			System.out.println(i + " -> " + rsMetadata.getColumnName(i));
		}
		// Throw resultSet into a List of Maps
		// Create a List of Maps
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSetMetaData rsMdata = resultSet.getMetaData();
		int colCount = rsMdata.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> rowMap = new HashMap<>();
			for (int col = 1; col <= colCount; col++) {
				rowMap.put(rsMdata.getColumnName(col), resultSet.getObject(col));
			}
			list.add(rowMap);
		}

		// print all employee ids from a list of maps
		for (Map<String, Object> map : list) {
			System.out.println(map.get("EMPLOYEE_ID"));
		}

		resultSet.close();
		statement.close();
		connection.close();
	}

}
