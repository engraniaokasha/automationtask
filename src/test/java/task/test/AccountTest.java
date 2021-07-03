package task.test;

import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationtaskafaqy.Account;
import automationtaskafaqy.formdata;
//import task.test.read_excel_data;


public class AccountTest {

	private WebDriver driver;	
	private Account createAccount;
	
	private formdata createAccountForm;

	@BeforeClass
	public void setup() {
		  System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		createAccount = new  Account(driver);
		createAccountForm = new formdata (driver);
		//String Url = "http://automationpractice.com/index.php";
		//driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
//click on sign in button 
	@Test(priority = 1)
	public void clickonsign_in() {
		 /* driver.findElement(By.className("login")).click();
			 driver.findElement(By.id("email_create")).sendKeys("tesfff@dffd.com");	 
			 driver.findElement(By.name("SubmitCreate")).click();*/
		createAccount.getSignInBtn().click();
	}
	
//test cases for email field
	@Test(priority = 2)
	public void testemailfield() {
		// empty email
		createAccount.getCreateAccountBtn().click();
		//wrong email
		createAccount.setCreateAccountEmailField("rania");
		createAccount.getCreateAccountBtn().click();
		// Registered email
		createAccount.setCreateAccountEmailField("test@test.com");
		createAccount.getCreateAccountBtn().click();
		// Correct email
		createAccount.setCreateAccountEmailField("raniaokasha@gmail.com");
		createAccount.getCreateAccountBtn().click();

	}

	/*@Test(priority = 3)
	public void personalInfoFields() {
		// With values
		createAccountForm.setCustomerFirstNameField("rania");
		createAccountForm.setCustomerLastNameField("okasha");
		createAccountForm.setCustomerEmailField("test@testex.com");
		createAccountForm.setCustomerPasswordField("tester123");
		createAccountForm.getAccountCreationForm().click();	
		// Without values
		createAccountForm.setCustomerFirstNameField("");
		createAccountForm.setCustomerLastNameField("");
		createAccountForm.setCustomerEmailField("");
		createAccountForm.setCustomerPasswordField("");

		createAccountForm.getAccountCreationForm().click();

		}*/

	@Test(priority = 4)
	public void requiredFieldsEmpty() {
		//createAccountForm.getAddressAliasField().clear();
		createAccountForm.setCustomerEmailField("");
		createAccountForm.selectCountry("-");
		createAccountForm.getRegisterBtn().click();		}
	//	createAccountForm.selectCountry("United States");
		//createAccountForm.getRegisterBtn().click();   }

	@Test(priority = 5)
     public void requiredFieldsInputFormat() throws Exception {
		// Wrong format
		/*createAccountForm.setCustomerEmailField("ranial");
		createAccountForm.setCustomerPasswordField("test");
		createAccountForm.setPostalCodeField("135");
		createAccountForm.setHomePhoneField("125");
		createAccountForm.setMobilePhoneField("5822");
		createAccountForm.getRegisterBtn().click();		}*/
		// Correct format
		createAccountForm.setCustomerEmailField("rania@test.com");
		createAccountForm.setCustomerPasswordField("tester");
		createAccountForm.setPostalCodeField("21000");
		createAccountForm.setHomePhoneField("056");
		createAccountForm.setMobilePhoneField("065");
		createAccountForm.getRegisterBtn().click();

	}

	@Test(priority = 6)
	public void accountwithvaliddata() {
		
		createAccountForm.setCustomerFirstNameField("rania");
		createAccountForm.setCustomerLastNameField("okasha");
		createAccountForm.setCustomerPasswordField("tester123");
		createAccountForm.selectCustomerDateOfBirthDay("15");
		createAccountForm.selectCustomerDateOfBirthMonth("3");
		createAccountForm.selectCustomerDateOfBirthYear("1996");
		createAccountForm.setAddressField("cairo");
		createAccountForm.setCityField("cairo");
		createAccountForm.selectState("7");
		createAccountForm.setPostalCodeField("11110");
		createAccountForm.setHomePhoneField("01127465097");
		createAccountForm.setMobilePhoneField("01135895555");
		createAccountForm.setAddressAliasField("My Address");
		createAccountForm.setCustomerEmailField("raniaokasha@test.com");
		createAccountForm.setCustomerPasswordField("tester123");
		createAccountForm.getRegisterBtn().click();
		
	}
	
	@AfterClass
	public void closeAll() {
		createAccount.getAccountLogout().click();
		driver.quit();
	}
	
	
	/*@DataProvider
	  public String [][]testdata() throws InvalidFormatException, IOException{
		  read_excel_data object=new read_excel_data();
		  return object.readsheet();
	  }*/
}
