import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class GmailLoginTestNG {
	LoginPageTest lpt = new LoginPageTest();
	DataFile df = new DataFile();
 
	  
  
  @BeforeMethod
  public void OpenBrowser() {
	lpt.openbrowser();  
	lpt.navigatetogmail("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	 
  }

  @AfterMethod
  public void afterTest() {
	  lpt.CloseBrowser();
	  
  }
  
  @Test
  public void EmptyEmail() throws InterruptedException {
	  lpt.EnterUserID("");
	  Thread.sleep(2000);
	  Assert.assertEquals(df.emailempty, lpt.readEmailError());  
  }
  @Test
  public void WrongEmail() throws InterruptedException {
	  lpt.EnterUserID(df.inValidEmail);
	  Thread.sleep(2000);
	  Assert.assertEquals(lpt.readEmailError(), df.wrongemailsms);
	  
  }
  @Test
  public void CorrectEmail() throws InterruptedException {
	  lpt.EnterUserID(df.correctemail);
	  
  }
  @Test
  public void EmptyPassword() throws InterruptedException {
	  lpt.EnterUserID(df.correctemail);
	  lpt.EnterPassword("");
	  Thread.sleep(2000);
	  Assert.assertEquals(lpt.readPasswordError(), df.emptypass);
	  
  }
  @Test
  public void WrongPassword() throws InterruptedException {
	  lpt.EnterUserID(df.correctemail);
	  lpt.EnterPassword(df.inCorrectPass);
	  Thread.sleep(2000);
	  Assert.assertEquals(lpt.readPasswordError(), df.passEmailErr);
	  
  }
  @Test
  public void CorrectPassword() throws InterruptedException {
	  lpt.EnterUserID(df.correctemail);
	  lpt.EnterPassword("tanvimahima");	
  }
}
