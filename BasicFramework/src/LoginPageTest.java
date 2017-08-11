import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPageTest {
	
	public WebDriver driver;
	
	@FindBy(id= "identifierId")
	public static WebElement email;
	
	@FindBy(xpath=".//*[@id='identifierNext']/content/span")
	public static WebElement emailNext;
	
	@FindBy(xpath=".//*[@name='password']")
	public static WebElement password;
	
	@FindBy(xpath=".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]")
	public static WebElement emailerror;
	
	@FindBy(xpath=".//*[@id='password']/div[2]/div[2]")
	public static WebElement passworderror;
	
	
	public void openbrowser(){
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
		
	}
	public void navigatetogmail(String x){
		driver.get(x);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	 
	public void CloseBrowser(){
		
		driver.quit();
	}
	
	
	public void EnterUserID(String a) throws InterruptedException{
		email.sendKeys(a);
		emailNext.click();
		
		Thread.sleep(2000);
	}
	
	public void EnterPassword(String b) throws InterruptedException{
		password.sendKeys(b);
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		
		Thread.sleep(2000);
	}

	public void passCheckErrMsg(String c){
		String actualErrMsg = driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]")).getText();
		System.out.println(actualErrMsg);
		
		String expectedErrMsg = c;
		Assert.assertEquals(expectedErrMsg, actualErrMsg);
		
	}
	public String readEmailError(){
		String actualErrMsg = emailerror.getText();
		return actualErrMsg;
	}
	public String readPasswordError(){
		String actualErrMsg = passworderror.getText();
		return actualErrMsg;
	}
	
}
	


