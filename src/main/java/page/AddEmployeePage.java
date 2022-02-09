package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import service.EmployeeService;
import utils.TestUtils;

public class AddEmployeePage extends TestUtils{
	@FindBy (xpath = "//input[@id='firstName']")
	public WebElement FirstNametxt;
	
	@FindBy (xpath = "//input[@id='lastName']")
	public WebElement LastNametxt;
	
	@FindBy (xpath = "//input[@id='dependants']")
	public WebElement Depedantstxt;
	
	@FindBy (xpath = "//button[@id='addEmployee']")
	public WebElement Addbtn;
	
	@FindBy (xpath = "//div[#'employeeModal']/div[@role='document']//button[@innertext='Cancel']")
	public WebElement Cancelbtn;
	
	

	public void addEmployeeDetails(EmployeeService employee) {
		FirstNametxt.sendKeys(employee.getFirstName());
		LastNametxt.sendKeys(employee.getLastName());
		Depedantstxt.sendKeys(employee.getDependent());
		Addbtn.click();		
	}
	
	public boolean isEmployeeFirstNameDisplayed(String firstName) {
		
		if(driver.findElement(By.xpath("//td[contains(text(),'"+firstName+"')]")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean isEmployeeLastNameDisplayed(String lastName) {
		
		if(driver.findElement(By.xpath("//td[contains(text(),'"+lastName+"')]")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	
	public boolean isEmployeebenefitCostDisplayed(String benefitCost) {
		
		if(driver.findElement(By.xpath("//td[contains(text(),'"+benefitCost+"')]")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean isEmployeenetPayDisplayed(String netPay) {
		
		if(driver.findElement(By.xpath("//td[contains(text(),'"+netPay+"')]")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
		
}//end of class

