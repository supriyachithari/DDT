package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class LoginPageTestDDT {
	
	public static void main(String[] args) throws FileNotFoundException,IOException{
	    File src=new File("C:\\Users\\sc225e\\Downloads\\Test.xlsx");
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb =new XSSFWorkbook(fis);
	    XSSFSheet sheet1=wb.getSheetAt(0);
	    
	    int rowcount=sheet1.getLastRowNum();
	    
	    System.setProperty("webdriver.edge.driver", "C:\\Users\\sc225e\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		for(int i = 0; i <= rowcount; i++) {
			driver.get("https://accounts.lambdatest.com/login");
			
			WebElement s =driver.findElement(By.name("email"));
			s.sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue());
			
			WebElement s1 =driver.findElement(By.id("password"));
			
			s1.sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.cssSelector("#login-button")).click();
			}
		driver.close();
		
	
}
}
