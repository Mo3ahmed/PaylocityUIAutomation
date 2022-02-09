package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import service.EmployeeService;
import utils.TestUtils;

public class UpdateEmployeePage extends TestUtils {
	
	@FindBy (xpath = "//input[@id='firstName']")
	public WebElement FirstNametxt;
	
	@FindBy (xpath = "//input[@id='lastName']")
	public WebElement LastNametxt;
	
	@FindBy (xpath = "//input[@id='dependants']")
	public WebElement Depedantstxt;
	
	@FindBy (xpath = "//button[@id='updateEmployee']")
	public WebElement UpdateEmployeebtn;
	
	@FindBy (xpath = "//*[@id=\"employeeModal\"]/div/div/div[3]/button[3]")
	public WebElement Cancelbtn;
	
	
	
	public void  updateEmployeeDetails(EmployeeService employee) {
		
		FirstNametxt.clear();
		FirstNametxt.sendKeys(employee.getFirstName());
		LastNametxt.clear();
		LastNametxt.sendKeys(employee.getLastName());
		Depedantstxt.clear();
		Depedantstxt.sendKeys(employee.getDependent());
		UpdateEmployeebtn.click();		
	}
		
}//end of class
