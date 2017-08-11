import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LoginTest {

	LoginPageTest lpt = new LoginPageTest();
	DataFile df = new DataFile();

	@Before
	public void setUp() throws Exception {
		
		lpt.openbrowser();
		lpt.navigatetogmail("https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}

	@After
	public void tearDown() throws Exception {
		//firefox should close
		lpt.CloseBrowser();		
	}

	@Test
	public void WrongPassword() throws InterruptedException {
		//enter correct email
		//click on next button
		//enter wrong password
		//click on signin button
		
		lpt.EnterUserID(df.correctemail);
		lpt.EnterPassword("df.inCorrectPass");
		Thread.sleep(2000);
		Assert.assertEquals(lpt.readEmailError(), df.emailErrMsg);		
	}
	@Test
	public void loginWithEmptyEmail() throws InterruptedException {
		lpt.EnterUserID("");
		Assert.assertEquals(lpt.readEmailError(), df.emptyEmailErr);
		
	}

}
