import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver  = new ChromeDriver();
	String myURL = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";
	
	@Test (priority = 1)
	public void mySetUp () {
		driver.get(myURL);
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		WebElement logIn = driver.findElement(By.id("login-button"));
		logIn.click();
		
	}
	
	@Test (priority = 2 , enabled = false)
	public void addAllItems () {
		List<WebElement> addToCartButton = driver.findElements(By.className("btn"));
		for (int i = 0 ; i<addToCartButton.size();i++) {
			addToCartButton.get(i).click();	
		}
	}
	
	
	@Test (priority = 3 ,enabled = false)
	public void addSomeItems (){	
		List<WebElement> addToCartButton = driver.findElements(By.className("btn"));
		for(int i = 0 ; i <addToCartButton.size(); i=i+2) {
			addToCartButton.get(i).click();
		}
	}
	

	@Test (priority = 4 , enabled = false)
	public void addSomeItemsAgain (){	
		List<WebElement> addToCartButton = driver.findElements(By.className("btn"));
		for(int i = 0 ; i <addToCartButton.size(); i++) {
			addToCartButton.get(i).click();
			if (i==4)
				break;
			
		}
	}
	@Test (priority = 5 ,enabled = false)
	public void addItemsThatHasLabs (){	
		List<WebElement> itemsName = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> addToCartButton = driver.findElements(By.className("btn"));
		for(int i = 0 ; i <itemsName.size(); i++) {
			itemsName.get(i).getText();
			//System.out.println(addToCartButton.get(i).getText());
			String ITEMSname = itemsName.get(i).getText();
			if (ITEMSname.contains("Labs")) {
				addToCartButton.get(i).click();
			
			}		}
	}

 @Test (priority = 6)
 public void PriceItem () {
	 List<WebElement> priceItems = driver.findElements(By.className("inventory_item_price"));
	 List<WebElement> addToCartButton = driver.findElements(By.className("btn"));
	 
  
		 for (int i = 0 ; i <priceItems.size() ; i++) {
			 String allPrice = priceItems.get(i).getText().replace("$", "");
			 double aa = Double.parseDouble(allPrice);
			 if (aa > 15.0) {
				 addToCartButton.get(i).click();
				 
			 }
		
	}
		 
	 }
	 
	 
 
 
 
 }
	

