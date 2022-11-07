import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class test1 {
	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shku2004\\Downloads\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		WebElement UserName = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		UserName.sendKeys("9473052048");

		WebElement Password = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		Password.sendKeys("Somu_210");

		WebElement login_button = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		login_button.click();

		// Search
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		search.sendKeys("iphone 11");
		Thread.sleep(3000);

		WebElement search_button = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		search_button.click();
		Thread.sleep(3000);

		// Current page verification

		String expectedTitle1 = "Iphone 11- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		Assert.assertEquals(driver.getTitle(), expectedTitle1, "Title mismatched 1");
		Thread.sleep(3000);

		// Selecting Product

		WebElement product = driver.findElement(By.xpath("//div[@class='_4rR01T']"));
		product.click();
		Thread.sleep(3000);

		// Current page verification
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		String expectedTitle2 ="APPLE iPhone 11 ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com";
		
		driver.switchTo().window(tabs1.get(1));
		
		Assert.assertEquals(driver.getTitle(), expectedTitle2,"Title mismatched 2"); 
		Thread.sleep(3000);
		
		//64 GB verification
		String expectedROM = "64 GB ROM";
		WebElement ROM = driver.findElement(By.xpath("//li[@class='_21Ahn-']"));
		String actualROM = ROM.getText();
		Assert.assertEquals(actualROM, expectedROM, "ROM mismatched");
		Thread.sleep(3000);
		
		//Adding to cart
		
		WebElement add_to_cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		add_to_cart.click();
		Thread.sleep(3000);
		
		// verifying if cart is open 
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		String expectedTitle3 ="Shopping Cart | Flipkart.com";
		//System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), expectedTitle3,"Title mismatched 3"); 
		

	}

}
 