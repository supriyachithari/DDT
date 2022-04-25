package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT {
	public static void main(String[] args) throws Exception {
		File src=new File("C:\\Users\\sc225e\\Downloads\\Test.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
	    XSSFSheet sheet1=wb.getSheetAt(0);
	    String data=sheet1.getRow(0).getCell(0).getStringCellValue();
	    System.out.println(data);
	    int rowcount=sheet1.getLastRowNum();
	    System.out.println("row count :"+rowcount);
	    int colcount = sheet1.getRow(1).getLastCellNum();
		System.out.println("column count : "+colcount);
	    for(int i=0;i<=rowcount;i++) {
	    	String d=sheet1.getRow(i).getCell(0).getStringCellValue();
	    	System.out.println("Row" +i+ ":"+ d);
	    }
	    for(int i=0;i<=rowcount;i++) {
	    	String d=sheet1.getRow(i).getCell(1).getRawValue();
	    	System.out.println("Row" +i+ ":"+ d);
	    }
	    fis.close();
	    FileOutputStream fos = new FileOutputStream("C:\\Users\\sc225e\\Downloads\\Test2.xlsx");
		
		wb.write(fos);
		
		fos.close();
	    
	}
}
