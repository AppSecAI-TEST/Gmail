
public class DataFile {


			Xls_Reader d = new Xls_Reader("/Users/chandernita/Desktop/Selenium/Testing/NikulTest.xlsx");
			public String correctemail = d.getCellData("Data1", "UserName", 2);
			public String inValidEmail = d.getCellData("Data1", "UserName", 3);
			public String inCorrectPass = d.getCellData("Data1", "Password", 2);
			public String emailErrMsg = d.getCellData("Data1", "Email Error", 2);
			public String emptyEmailErr = d.getCellData("Data1", "Email Error", 3);
			public String passEmailErr = d.getCellData("Data1", "Password Error", 2);
			public String emailempty = "Enter an email or phone number";
			public String validemail = "coolpeople93";
			public String emptypass = "Enter a password";
			public String wrongemailsms = "Couldn't find your Google Account";
			public String Facefirstname = "Myra";
			public String Facelastname = "Saigal";
			public String Facemobilenum = "+917837946969";
			public String Facenewpassword = "Myra"; 
			public String EmptyFirstLasterrsms = "What’s your name?";
			public String Emptymobilenumsms ="You'll use this when you log in and if you ever need to reset your password.";
			public String EmptyNewPasswordsms ="Enter a combination of at least six numbers, letters and punctuation marks (like ! and &).";
			public String UnselectedRadiosms = "Please choose a gender. You can change who can see this later.";
			public String Incorrectpasssms = "Your password must be at least 6 characters long. Please try another.";
			



			

		

	

}
