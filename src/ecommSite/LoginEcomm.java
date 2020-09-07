package ecommSite;

import java.util.List;

import WebDriverWait;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
public class LoginEcomm {

	WebDriver driver ;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver"," C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		
		//Test Case 1
        driver.get("http://www.ctqatest.biz/ecom/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()='Account']")).click();
        driver.findElement(By.xpath("//*[text()='Log In']")).click();
        
        driver.findElement(By.name("login[username]")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).sendKeys("ThisIsT3st");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(2000);
        
        //Test case 2
        String actual_error = driver.findElement(By.xpath(".//li[@class='error-msg']//ul//li//span')]")).getText();
        String expected_error="Invalid login or password.";
        Assert.assertEquals(actual_error, expected_error);
        //Assert.assertTrue(actual_error.contains("Invalid login or password"));
        System.out.println("Test passed");
        
        driver.navigate().refresh();
        
        //Test case 3
        driver.findElement(By.id("search")).sendKeys("shirt");
        driver.findElement(By.linkText("Slim fit Dobby Oxford Shirt")).click();
        
        WebElement selectColor_dropdown=driver.findElement(By.id("attribute92"));
        Select color = new Select(selectColor_dropdown);
        color.selectByVisibleText("Blue");
        
        WebElement selectSize_dropdown=driver.findElement(By.id("attribute180"));
        Select size = new Select(selectSize_dropdown);
        size.selectByVisibleText("XS");
        
        driver.findElement(By.className("add-to-cart")).click();
        
        driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Cart')]"));
        wait = new WebDriverWait(driver,2);
        Assert.assertTrue(driver.getTitle().equals("Shopping Cart"));
        
        WebElement sale = driver.findElement(By.xpath("//a[contains(text(),'Sale')]"));
        
        Actions act = new Actions(driver);
        act.moveToElement(sale).perform();
        
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='level0']");
        
        for (WebElement link : links)
        	
        { 
        	if link.getText().contains("view-all"))
        	
        	{
        	link.click();
        	break;
        	}
        
        }
        
        //Test case 4
        
        Thread.sleep(5000);
        
        ((JavascriptExecutor)driver).executeScript("scroll(0,4000)");
        
        driver.findElement(By.xpath("//a[contains(@href,'price=100-200')]")).click();
        
        WebElement table = driver.findElement(By.xpath("//span[text()='Special Price'])";
        List<WebElement> rows = table.findElements(By.xpath("//span[contains(@id,'product-price')]"));
        int i  = 0;
        
       
          while(i.hasNext()) {
            WebElement rows = i.next();
            String str =rows.getText();
                newstr = newstr.replace("$",str);
                newstr = newstr.trim();
               
               double dnum = Double.parseDouble(newstr);

        if (dnum >100 && dnum<199 )
        {
        System.out.println("price of element is in correct price bracket " + rows.getText());

         }
         else 
         {

         System.out.println("price of element is not in correct price bracket " + rows.getText());

         }
        
        driver.quit();
        
        
       }

}
}
