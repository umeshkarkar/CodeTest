package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
	public static void loadExcel() throws IOException
	{
		 fis =new FileInputStream("./codeTest.xlsx");
		 workbook=new XSSFWorkbook(fis);
		 sheet =workbook.getSheet("TestData");
		 fis.close();		
	}
	
	public static Map<String, Map<String, String>> getDataMap() throws IOException
	{
		if(sheet==null)
		{
			loadExcel();
		}
		
		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		Map<String, String> myMap =new HashMap<String, String>();
		
		for(int i=1; i<sheet.getLastRowNum()+1; i++)
		{
			row =sheet.getRow(i);
			String keyCell =row.getCell(0).getStringCellValue();
			
			int colNum=row.getLastCellNum();
			
			for(int j=1; j<colNum; j++)
			{
				String value =row.getCell(j).getStringCellValue();
				myMap.put(keyCell, value);
			}
			superMap.put("MasterData", myMap);			
		}		
		return superMap;
	}
	
	public static String getvalue(String key) throws IOException
	{
		Map<String, String> myVal=getDataMap().get("MasterData");
		String retValue =myVal.get(key);
		
		return retValue;		
	}
		
	public static void main(String[] args) throws IOException
	{
		System.out.println(getvalue("cust_FirstName"));
	
	}

}

