import org.testng.annotations.Test;

import org.testng.Assert;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class FaceBookSignUp {
	FacebookSignuppage fs = new FacebookSignuppage();
	DataFile df = new DataFile();
	
  @Test
  public void EmptyFirstName() {
	  fs.FirstName("");
	  fs.LastName(df.Facelastname);
	  fs.MobileEmail(df.Facemobilenum);
	  fs.NewPassword(df.Facenewpassword);
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  fs.Gender(0);
	  fs.CreateButton();
	  Assert.assertEquals(df.EmptyFirstLasterrsms, fs.FirstLastnameerr());
  }
  @Test
  public void EmptyLastName() {
	  fs.FirstName(df.Facefirstname);
	  fs.LastName("");
	  fs.MobileEmail(df.Facemobilenum);
	  fs.NewPassword(df.Facenewpassword);
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  fs.Gender(0);
	  fs.CreateButton();
	  Assert.assertEquals(df.EmptyFirstLasterrsms, fs.FirstLastnameerr());
  }
  @Test
  public void EmptyMobilenum() {
	  fs.FirstName(df.Facefirstname);
	  fs.LastName(df.Facelastname);
	  fs.MobileEmail("");
	  fs.NewPassword(df.Facenewpassword);
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  fs.Gender(0);
	  fs.CreateButton();
	  System.out.println(fs.FirstLastnameerr());
	  Assert.assertEquals(df.Emptymobilenumsms, fs.FirstLastnameerr());
  }
  @Test
  public void EmptyNewpassword() {
	  fs.FirstName(df.Facefirstname);
	  fs.LastName(df.Facelastname);
	  fs.MobileEmail(df.Facemobilenum);
	  fs.NewPassword("");
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  fs.Gender(0);
	  fs.CreateButton();
	  Assert.assertEquals(df.EmptyNewPasswordsms, fs.FirstLastnameerr());
  }
  @Test(priority=1)
  public void BirthMonthdropdown() {
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  
  }
  @Test
  public void UnselectedGender() throws InterruptedException {
	  fs.FirstName(df.Facefirstname);
	  fs.LastName(df.Facelastname);
	  fs.MobileEmail(df.Facemobilenum);
	  fs.NewPassword(df.Facenewpassword);
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  fs.CreateButton();
	  Thread.sleep(2000);
	  Assert.assertEquals(df.UnselectedRadiosms, fs.FirstLastnameerr());
  }
  @Test
  public void Incorrectpassword() throws InterruptedException {
	  fs.FirstName(df.Facefirstname);
	  fs.LastName(df.Facelastname);
	  fs.MobileEmail(df.Facemobilenum);
	  fs.NewPassword(df.Facenewpassword);
	  fs.BirthMonth("July");
	  fs.BirthDay("9");
	  fs.BirthYear("1985");
	  fs.Gender(0);
	  fs.CreateButton();
	  Thread.sleep(2000);
	  Assert.assertEquals(fs.IncorrectPassword(), df.Incorrectpasssms);
  }
  @BeforeMethod
  public void beforeMethod() {
	  fs.openBrowser();
	  fs.navigatetoemail("https://www.facebook.com/");  
  }

  @AfterMethod
  public void afterMethod() {
	  fs.closeBrowse();
  }

}
