package p3_package.dao;
import java.sql.*;

import oracle.net.jdbc.TNSAddress.SOException;
public abstract class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "sijmen10";
	private static final String DB_PASS = "515109";
	private static Connection conn;
	//basic basedao Set up based on tutorials in class and cleaned up by myself
	public OracleBaseDao() {}
	public Connection getConnection(){
		//get a connection;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		
		return conn;
	}
	//close the connection(not used in my method, but possible to use, I get around it)
	public void closeConnection() {
		try {
			conn.close();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
