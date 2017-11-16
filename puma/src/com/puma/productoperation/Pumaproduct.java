package com.puma.productoperation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.thoughtworks.selenium.webdriven.commands.GetText;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;

public class Pumaproduct 
{
	public static void main(String[]args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://in.puma.com");
		String title = driver.getTitle();
		//String actualmsg=driver.getTitle();
		Actions act=new Actions(driver);
		WebElement wb2 = driver.findElement(By.xpath("//ul[@class='digimeg-group digimeg-main-nav']/li/a[@data-subnav='men-subnav']"));
		//wb2.click();
		act.moveToElement(wb2).perform();
		WebElement wb3 = driver.findElement(By.xpath(".//*[@id='men-subnav']/div/div/div[2]/ul/li[2]/a"));
		String s1 = wb3.getText();
		System.out.println("checkinggg:::   "+ s1);
		wb3.click();
		WebElement wb4 = driver.findElement(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']/li[@class='item last'][2]"));
		wb4.click();
		Set<String>st1=driver.getWindowHandles();
		System.out.println("size is here:::::: "+st1);
		Iterator<String>it1=st1.iterator();
		String parentwindowid=it1.next();
		String childwindowid=it1.next();
		
		driver.switchTo().window(childwindowid);
		System.out.println("coming herere0000");
		WebElement wb5 = driver.findElement(By.xpath("//div[@class='product-size-click-btn']"));
		wb5.click();
		System.out.println("coming herere1111");
		WebDriverWait wait=new WebDriverWait(driver, 8);
		//waiting for login button(shortcut circle pointer)
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='product-size-div']/ul[@id='configurable_swatch_size']/li[@class='option-8']")));
		System.out.println("coming herere222");
		WebElement wb6 = driver.findElement(By.xpath("//div[@class='product-size-div']/ul[@id='configurable_swatch_size']/li[@class='option-8']"));
		wb6.click();
		System.out.println("coming herere333");
		for(int i = 0; i<=3; i++){
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Add to Cart')]")));
		System.out.println("coming herere............");
		WebElement wb7 = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
		String s7 = wb7.getText();
		System.out.println("checkinggg:::   "+ s7);
		wb7.click();
		System.out.println("clicked on add to cart............");
		break;
		}catch(Exception e1){
			System.out.println("coming herere4444");
			
			}
		}
		
		System.out.println("coming herere4444");
		// assert correct shoe name after add to card with the prevoius select
		String actualvalue=driver.findElement(By.xpath("//tr[@class='first last odd']/td[2]/h2/following-sibling::div[1]")).getText();
		//System.out.println(actualvalue);
		//String ExpectedValue="SKU: 4057828126883 ";
		//Assert.assertEquals(actualvalue, ExpectedValue);
		System.out.println("testcase=='passed");
		String expectedvalue="Speed 1000 IGNITE Men's Running Shoes was added to your shopping cart.";
		Assert.assertEquals(driver.getTitle(), expectedvalue);
		
	}

}
