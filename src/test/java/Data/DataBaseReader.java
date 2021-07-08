package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseReader {
	
	String jdbcUrl = "jdbc:sqlite:/"+System.getProperty("user.dir")+ "/src/test/java/data/sbdb.db";
	Connection connection;
	Statement statement;
	ResultSet result;
	String sql;
	private String ItemName;
	private String price;
	private String first_colunmresult;
	private String sec_colunmresult;
	
	
	
	public ResultSet DataBaseRead(String sql) throws SQLException
	{
		connection = DriverManager.getConnection(jdbcUrl);
		statement = connection.createStatement();
		result = statement.executeQuery(sql);
		return result;
	}

	/*
	public void setResult(ResultSet result) throws SQLException
	{
		while(result.next())
		{
			ItemName = result.getString("ItemNameE");
			price = result.getString("GrossSalePrice");
			
		}
	}
	
	*/
	
	protected void setResult(ResultSet result,String colunm) throws SQLException {
		
		while(result.next())
		{
			first_colunmresult = result.getString(colunm);
			
		}
		
	}

	protected void setResult(ResultSet result,String first_colunm, String sec_coulum) throws SQLException {
		
		while(result.next())
		{
			first_colunmresult = result.getString(first_colunm);
			sec_colunmresult = result.getString(sec_coulum);
		}
		
	}


	public String getFirstColunmResult()
	{
		return first_colunmresult;
	}
	
	public String getSecColunmResult()
	{
		return sec_colunmresult;
	}
		
	
	

}
