package search;

import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;

public class Draw {
	
	private static String URL = "https://www.youidraw.com/apps/painter/";
	private static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		
		System.setProperty("webdriver.chrome.driver", 
				"src/test/resources/resources/drivers/chromedriver.exe");
		
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);
		
		driver = new ChromeDriver(cOptions);
		//driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
		
	}
	
	@Test
	public void searchdraw() {
		driver.get(URL);
		
		 assertEquals("YouiDraw Painter, Painting Tools online.", driver.getTitle());
		
	}
	
	@Test
	public void drawURLTest() {
		driver.get(URL);
		assertEquals("https://www.youidraw.com/apps/painter/", driver.getCurrentUrl());
		
	}
	
	@Test
	public void drawlettertest() throws InterruptedException {
		
		WebElement draw = driver.findElement(By.id("painter"));
		Actions action = new Actions(driver); 
		Action seriesOfActions = action
				.moveToElement(draw)
				.clickAndHold()
				.moveByOffset(0, 200)
				.build();
		
		seriesOfActions.perform();
		Thread.sleep(2000);
		
	}

}
