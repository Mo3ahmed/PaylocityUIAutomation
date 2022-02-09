package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import page.AddEmployeePage;
import page.BenefitsDashboardPage;
import page.UpdateEmployeePage;
import utils.TestUtils;

public class TestBase extends TestUtils {
	
	public BenefitsDashboardPage benefitsDashbaordPage;
	public AddEmployeePage addEmployeePage;
	public UpdateEmployeePage updateEmployeePage;
	
	
	@BeforeMethod
	public void setUp() {
			
		setDriver();
		addEmployeePage = PageFactory.initElements(driver, AddEmployeePage.class);
		benefitsDashbaordPage = PageFactory.initElements(driver, BenefitsDashboardPage.class);
		updateEmployeePage = PageFactory.initElements(driver, UpdateEmployeePage.class);	
			
	}
	
	@AfterMethod
	public void tearDown() {
		
		quitDriver();
	
	}
}
