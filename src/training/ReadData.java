package training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;


public class ReadData {
	String propdataName;

	public String getProperties(String propertyName) throws Exception{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("Objects.properties");
		prop.load(fis);
		return prop.getProperty(propertyName);
	}
	
	
	@Test
	public void Test() throws Exception{
		
		System.out.println(getXpath("LOGIN_POPUP"));
		System.out.println(getXpath("LOGIN_FIELD"));
		System.out.println(getXpath("PASSWORD_FIELD"));
		System.out.println(getXpath("LOGIN_BTN"));
		System.out.println(getXpath("LOGIN_SINEUP_LINK"));
		System.out.println(getXpath("LOGIN_POPUP_X_BTN"));
	}
	
	    public String getXpath(String sObject) throws Exception {
	    	String xPath= "";
	        String excelFilePath = "data.xls";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	         
	        Workbook workbook = new HSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        while (iterator.hasNext()) {
	        	Row row= iterator.next();
		        Cell cell= row.getCell(0);
		        if(cell.getStringCellValue().trim().equalsIgnoreCase(sObject.trim())){
//		        	switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                    	xPath = row.getCell(1).getStringCellValue();
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                    	xPath = Boolean.toString(row.getCell(1).getBooleanCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                    	xPath = Double.toString(row.getCell(1).getNumericCellValue());
//                        break;
//                }
		        	xPath = row.getCell(1).getStringCellValue();
		        	break;
		        }
	        }
	        return xPath;
	           
	    }
	 
}
