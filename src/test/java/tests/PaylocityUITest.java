package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import page.UpdateEmployeePage;
import service.EmployeeService;


public class PaylocityUITest extends TestBase {
	
	@Test
	public void verifyAddEmployee() {
		
		//Start Test date
		int randomNumber = (int )(Math.random() * 1000 + 500);
		
		String firstName = "Test"+randomNumber;
		String lastName = "Paylocity"+randomNumber;
		String benefitCost = "76.92";
		String netPay = "1923.08";
		//End Test date		
		
		//creating an object for setting employee data
		EmployeeService employee = new EmployeeService(firstName, lastName,"2");
		
		benefitsDashbaordPage.verifyTitle(driver, "Employees - Paylocity Benefits Dashboard");
		benefitsDashbaordPage.clickAddBtn();
		addEmployeePage.addEmployeeDetails(employee);
		
		Assert.assertTrue(addEmployeePage.isEmployeeFirstNameDisplayed(firstName));
		Assert.assertTrue(addEmployeePage.isEmployeeLastNameDisplayed(lastName));
		Assert.assertTrue(addEmployeePage.isEmployeebenefitCostDisplayed(benefitCost));
		Assert.assertTrue(addEmployeePage.isEmployeenetPayDisplayed(netPay));
				
	}
	
	
	
	@Test
	public void verifyUpdateEmployee() {
		
		if(benefitsDashbaordPage.isExist(benefitsDashbaordPage.UpdateEmployeebtn)) {
			 verifyAddEmployee();
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
			
		//Start Test date
		int randomNumber = (int )(Math.random() * 1000 + 500);
		
		String firstName = "UpdateTest"+randomNumber;
		String lastName = "UpdatePaylocity"+randomNumber;
		String benefitCost = "38.46";
		String netPay = "1961.54";
		//End Test date
		
		EmployeeService employee = new EmployeeService(firstName, lastName,"0");
		
		benefitsDashbaordPage.clickUpdateBtn();
		updateEmployeePage.updateEmployeeDetails(employee);
		
		Assert.assertTrue(addEmployeePage.isEmployeeFirstNameDisplayed(firstName));
		Assert.assertTrue(addEmployeePage.isEmployeeLastNameDisplayed(lastName));
		Assert.assertTrue(addEmployeePage.isEmployeebenefitCostDisplayed(benefitCost));
		Assert.assertTrue(addEmployeePage.isEmployeenetPayDisplayed(netPay));
		
	}
	

	@Test
	public void verifyDeleteEmployee() {
		
		if(benefitsDashbaordPage.isExist(benefitsDashbaordPage.DeleteEmployeebtn)) {
			 verifyAddEmployee();
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		benefitsDashbaordPage.clickDeleteBtn();
		
		String firstName = benefitsDashbaordPage.DeletedFirstName.getText();
		String lastName =  benefitsDashbaordPage.DeletedLastName.getText();
		System.out.println("Delete First name: "+firstName+ "Last name: "+lastName);
		
		benefitsDashbaordPage.clickConfirmDeleteBtn();
	}

	
//	@Test
//	public void deleteAnEmployee() {
//		
//		benefitsDashbaordPage.deleteSpecificEmployee("Steve");	
//		driver.findElement(By.id("deleteEmployee")).click();
//
//	}


}
