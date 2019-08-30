package eu.ase.jdbc_sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {

	/**
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args)  {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			
			createDBTable(c);
			insertData(c);
			selectData(c);
			
			c.close();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} 
	} //end main
	
	public static void createDBTable(Connection c) throws SQLException {
		Statement stmt = null;
		stmt = c.createStatement();
		String sqlDropTable = "drop table COMPANY";
		String sqlCreateTable = "create table COMPANY " +
				"(ID INT PRIMARY KEY NOT NULL, " +
				"NAME TEXT NOT NULL, AGE INT NOT NULL, ADDRESS CHAR(50), " +
				"SALARY REAL)";
		stmt.executeUpdate(sqlDropTable);
		stmt.executeUpdate(sqlCreateTable);
		stmt.close();
	}
	
	public static void insertData(Connection c) throws SQLException {
		Statement stmt = null; String sql = null;
		stmt = c.createStatement();
		
		sql = "insert into COMPANY(ID, NAME, AGE, ADDRESS, SALARY)" +
				" values(1, 'Paul', 32, 'B', 20000.0)";
		stmt.executeUpdate(sql);
		
		sql = "insert into COMPANY(ID, NAME, AGE, ADDRESS, SALARY)" +
				" values(2, 'Gigel', 25, 'BV', 15000.0)";
		stmt.executeUpdate(sql);
		
		sql = "insert into COMPANY(ID, NAME, AGE, ADDRESS, SALARY)" +
				" values(3, 'Ionel', 18, 'TM', 10000.0)";
		stmt.executeUpdate(sql);
		
		stmt.close();
		c.commit();
	}

	public static void selectData(Connection c) throws SQLException {
		Statement stmt = null;
		stmt = c.createStatement();
		String sql = "select * from COMPANY;";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String address = rs.getString("address");
			float salary = rs.getFloat("salary");
			System.out.println("ID = "+id+", Name = "+name+", AGE = "+age+", Address = "+address+", salary = "+salary);
		}
				
		rs.close();
		stmt.close();
	}

} //end class


