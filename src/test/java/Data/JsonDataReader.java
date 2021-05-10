package Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	public String payment_method, product_name , product_value , product_type  ; 

	public void JsonReader() throws IOException, ParseException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";

		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject person = (JSONObject) jsonObj ; 
			payment_method  = (String) person.get("payment_method"); 
			System.out.println(payment_method);

			product_name = (String) person.get("product_name"); 
			System.out.println(product_name);

			product_value = (String) person.get("product_value"); 
			System.out.println(product_value);

			product_type = (String) person.get("product_type"); 
			System.out.println(product_type);

		}
		
	}

}
