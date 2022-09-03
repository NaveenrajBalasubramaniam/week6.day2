package week6.day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lead {
	public EdgeDriver driver;
	 @BeforeMethod
	  public void preCondition() {
		 WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement username=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.className("decorativeSubmit"));
		username.sendKeys("demosalesmanager");
		password.sendKeys("crmsfa");
		login.click();
	}
	 @Test(dataProvider ="testdata")
	 public void testLead(String cname,String fname,String lname,String fNamelocal, String lNameLocal, String deptName, String deptDesc) {
		 driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fNamelocal);
			driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys(lNameLocal);
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(deptName);
			driver.findElement(By.id("createLeadForm_description")).sendKeys(deptDesc);
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("naveenraj@gmail.com");
			WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select drop=new Select(state);
			drop.selectByVisibleText("New York");
			driver.findElement(By.className("smallSubmit")).click();
			System.out.println(driver.getTitle()); 
	 }
	 @DataProvider
		public String[][] testdata() {
		   //2D array to store the test data
		   String[][] data=new String[2][7];
		   data[0][0]="Testleaf";
		   data[0][1]="NaveenRaj";
		   data[0][2]="Bala";
		   data[0][3]="N";
		   data[0][4]="B";
		   data[0][5]="Quality Dept";
		   data[0][6]="Quality dept checks the quality of the product";
		   
		   data[1][0]="Testleaf1";
		   data[1][1]="NaveenRaj1";
		   data[1][2]="Bala1";
		   data[1][3]="N1";
		   data[1][4]="B1";
		   data[1][5]="Quality Dept1";
		   data[1][6]="Quality dept checks the quality of the product1";
		   return data;
		   	   
	}
	 
	 
	 @AfterMethod
		public void postCondition() {
			driver.close();

		}

	

}
