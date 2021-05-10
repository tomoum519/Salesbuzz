package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	/*
	public static void main(String[] args) throws IOException
	{
		ExcelReader test = new ExcelReader();
		test.getFileInputStream();
		test.getExcelData();
	}
	*/
	static FileInputStream fil = null;
	
	public FileInputStream getFileInputStream() 
	{
		String filepath = System.getProperty("user.dir")+"/src/test/java/data/userdata.xlsx";
		File scrfile = new File(filepath); 
		
		try {
			fil = new FileInputStream(scrfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("the excel doesn't found "+ e.getMessage() );
		}
		return fil;
	}
	

	public Object[][] getExcelData() throws IOException
	{
		fil = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println(sheet.getLastRowNum());
		
		int totalnumberofrows = (sheet.getLastRowNum()+1);
		int totalnumberofcolumns = 4 ;
		
		String[][] arrayExcelData = new String[totalnumberofrows][totalnumberofcolumns];
		
		for (int i = 1; i < totalnumberofrows;i++)
		{
			for (int j = 0; j < totalnumberofcolumns;j++)
			{
				XSSFRow row = sheet.getRow(1);
				arrayExcelData[i-1][j] = row.getCell(j).toString();
				System.out.println(arrayExcelData[i-1][j]);
			}
			
		}
		
		wb.close();
		return arrayExcelData;
		
	}
}
