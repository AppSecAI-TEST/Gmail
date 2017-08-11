import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookSignuppage {

	WebDriver driver;
	@FindBy(name="firstname")
	public static WebElement firstname;
	
	@FindBy(name="lastname")
	public static WebElement lastname;
	
	@FindBy(xpath=".//*[@name='reg_email__']")
	public static WebElement mobileemail;
	
	@FindBy(css="input[name='reg_passwd__']")
	public static WebElement newpassword;
	
	@FindBy(id="day")
	public static WebElement birthday;
	
	@FindBy(css="#year")
	public static WebElement birthyear;
	
	@FindBy(css="button[name='websubmit']")
	public static WebElement createaccount;
	
	@FindBy(xpath=".//*[@id='reg_error_inner']")
	public static WebElement incorrectpassword;
	
	

		public void openBrowser(){
			driver=new FirefoxDriver();
			PageFactory.initElements(driver, this);
		}
		public void navigatetoemail(String x){
			driver.get(x);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		public void closeBrowse(){
			driver.quit();
		}
		public void FirstName(String a){
			firstname.sendKeys(a);
		}
		public void LastName(String b){
			lastname.sendKeys(b);
		}
		public void MobileEmail(String c){
			mobileemail.sendKeys(c);
		}
		public void NewPassword(String d){
			newpassword.sendKeys(d);	
		}
		public void BirthMonth(String e){
			driver.findElement(By.id("month")).sendKeys(e);
		}
		public void BirthDay(String f){
			birthday.sendKeys(f);
		}
		public void BirthYear(String g){
			birthyear.sendKeys(g);
		}
		public void Gender(int k){
			List<WebElement> radiobutton = driver.findElements(By.xpath(".//*[@class='_5k_2 _5dba']"));
			radiobutton.get(k).click();
			}
		public void CreateButton(){
			createaccount.click();
			
		}
		public String FirstLastnameerr(){
			String actualerrsms = driver.findElement(By.cssSelector("div[class='_5633 _5634 _53ij']")).getText();
			return actualerrsms;											
		}
		public String IncorrectPassword(){
			String actualerror = incorrectpassword.getText();
			return actualerror;
		}
}
