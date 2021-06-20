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
	
	
	public DataBaseReader() throws SQLException
	{
		connection = DriverManager.getConnection(jdbcUrl);
		sql = "select i.ItemNameE , p.GrossSalePrice \r\n"
				+ "from HH_Item i, HH_ItemPrice p\r\n"
				+ "on i.ItemNo = p.ItemNo\r\n"
				+ "where p.ItemNo = \"1318754\" and p.SellingPriceCode = \"ws\" and p.UOM = \"CTN\"";
		statement = connection.createStatement();
		result = statement.executeQuery(sql);
		
		while(result.next())
		{
			ItemName = result.getString("ItemNameE");
			price = result.getString("GrossSalePrice");
			
			System.out.println(ItemName +"   "+ price);
		}
	}

	
	public String getname()
	{

		return ItemName;
	}
	
	public String getprice()
	{

		return price;
	}
		
		
	
	

}
