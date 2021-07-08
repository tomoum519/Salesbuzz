package Data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesOrderDataBase extends DataBaseReader {
	
	private String first_colunmresult;
	private String sec_colunmresult;




	public void avaibleQuantityQuery(String product_id) throws SQLException
	{
		setResult(DataBaseRead("select C.CurrentStock \r\n"
				+ "from HH_CARSTORE C,  HH_Item I\r\n"
				+ "on C.ITEMNO = I.ItemNo\r\n"
				+ "where I.ItemNo = \""+product_id+"\""),"CurrentStock");
	}
	
	public void unitPriceQuery(String product_id, String customer , String product_type) throws SQLException
	{
		setResult(DataBaseRead("select GrossSalePrice \r\n"
				+ "from HH_ItemPrice \r\n"
				+ "where ItemNO = \""+product_id+"\" and SellingPriceCode = (select priceid from hh_customer where CustomerNameE like '%"+customer+"%') and UOM = '"+product_type+"'  \r\n"
				+ "group by ItemNo \r\n"
				+ "having max(PriceDate) \r\n"
				+ "order by PriceDate Desc"),"GrossSalePrice");
	}
	
	public void factorCalculationQuery(String product_id) throws SQLException
	{
		setResult(DataBaseRead("select Factor \r\n"
				+ "from HH_ItemUoms \r\n"
				+ "where ItemNO = \""+product_id+"\" \r\n"
				+ "group by ItemNo"),"Factor");
	}
	
	public void defaultUnitQuery(String product_id) throws SQLException
	{
		setResult(DataBaseRead("select DefaultUOM \r\n"
				+ "from HH_Item \r\n"
				+ "where ItemNo = \""+product_id+"\""),"DefaultUOM");
	}
	
}
