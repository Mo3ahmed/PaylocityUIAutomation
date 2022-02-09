package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.TestUtils;

public class BenefitsDashboardPage extends TestUtils {
	
	@FindBy (xpath = "//a[text()='Paylocity Benefits Dashboard']")
	public WebElement PageTittle;
	
	@FindBy (xpath = "//a[text()='Log Out']")
	public WebElement LogOutbtn;
	
	@FindBy (xpath = "//button[@id='add']")
	public WebElement AddEmployeebtn;
	
	@FindBy (xpath = "//i[@class='fas fa-times']")
	public List<WebElement> DeleteEmployeebtn;
	
	@FindBy (xpath = "//i[@class='fas fa-edit']")
	public List<WebElement> UpdateEmployeebtn;
	
	
	@FindBy (xpath = "//td[2]")
	public List<WebElement> GetEEFirstName;
	
	@FindBy (xpath = "//td[3]")
	public List<WebElement> GetEELastName;
	
	@FindBy (xpath = "//span[@id='deleteFirstName']")
	public WebElement DeletedFirstName;
	
	@FindBy (xpath = "//span[@id='deleteLastName']")
	public WebElement DeletedLastName;
	
	@FindBy (xpath = "//button[@id='deleteEmployee']")
	public WebElement ConfirmDeleteBtn;
	
	public boolean isExist(List<WebElement> empList)	{
		
		if(empList.size() < 1) {
		return true;
	}
		return false;
	}//end of if else 
	
	public void verifyTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals("Employees - Paylocity Benefits Dashboard"));
	}
	
	public void clickAddBtn() {
		AddEmployeebtn.click();
	}
	
	public void clickUpdateBtn() {
		UpdateEmployeebtn.get(0).click();
	}
	
	public void clickDeleteBtn() {
		DeleteEmployeebtn.get(0).click();			
	}
	
	public void clickConfirmDeleteBtn() {			
		ConfirmDeleteBtn.click();
	}
	
	public void deleteSpecificEmployee(String employeeName) {
		driver.findElement(By.xpath("//tbody/tr//td[contains(text(),'"+employeeName+"')]/following-sibling::td[7]//i[2]")).click();		
	}	
	
	

}//end of class
