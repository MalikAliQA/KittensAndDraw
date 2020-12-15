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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IndexPage {
	
	private static String URL = "localhost:9092/index.html";
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest test;

	@BeforeClass
	public static void setup() {

		extent = new ExtentReports("src/test/resources/reports/report2.html", true);
		test = extent.startTest("ExtentDemo");
		;

		System.setProperty("webdriver.chrome.driver", "src/test/resources/resources/drivers/chromedriver.exe");

		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);

		driver = new ChromeDriver(cOptions);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
		extent.close();

	}

	@Test
	public void searchindex() throws InterruptedException {
		// driver.get(URL);

		// assertEquals("Google", driver.getTitle());
		driver.get(URL);
		Thread.sleep(3000);
		if (("Google").equals(driver.getTitle())) {
			test.log(LogStatus.PASS, "Success Title");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}

	}

	@Test
	public void indexURLTest() {
		// driver.get(URL);
		// assertEquals("https://www.google.com/", driver.getCurrentUrl());
		driver.get(URL);
		if (("localhost:9092/index.html").equals(driver.getCurrentUrl())) {
			test.log(LogStatus.PASS, "Success URL");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}

	}

	@Test
	public void imagesearhTest() throws InterruptedException {

//		driver.get(URL + "/images");
//		System.out.println(URL + "/images");
//		WebElement input = driver.findElement(By.name("q"));
//		//new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(input));
//		input.sendKeys("Kittens");
//		
//		input.submit();
//		//WebElement images = driver.findElement(By.cssSelector("#islrg > div.islrc > div:nth-child(1) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img"));
//		WebElement images = driver.findElement(By.cssSelector("#islrg > div.islrc > div:nth-child(6) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img"));
//		//WebElement images = driver.findElement(By.className("islrc"));
//		//List<WebElement> listResult = images.findElements(By.tagName("img"));
//		//System.out.println(listResult.size());
//		Actions action = new Actions(driver); 
//		action.moveToElement(images).click().perform();
//		System.out.println("after click" + driver.getCurrentUrl());
//		Thread.sleep(2000);
//		//images.click();
//		//action.moveToElement(listResult.get(0)).click().perform();
//		//String kittenImgURL = listResult.get(3).getAttribute("src").toString();
//		//System.out.println(kittenImgURL);
//		//https://www.google.com/search?q=kittens&tbm=isch&ved=2ahUKEwj7wIOe38_tAhUxgM4BHaTCCVkQ2-cCegQIABAA&oq=kittens&gs_lcp=CgNpbWcQAzIECCMQJzIECAAQQzIECAAQQzIFCAAQsQMyAggAMgIIADICCAAyAggAMgIIADICCAA6BwgAELEDEENQywNYwAlg2ApoAHAAeACAAYMBiAGpBJIBAzYuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=UIvYX_vYDbGAur4PpIWnyAU&bih=968&biw=960#imgrc=aho3vIBpPKjgZM
//		//*[@id="islrg"]/div[1]/div[2]/a[1]/div[1]/img
//		if ((images).equals(driver.findElement(By.cssSelector("#islrg > div.islrc > div:nth-child(6) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img")))) {
//			test.log(LogStatus.PASS, "Success Image Test");
//		} else {
//			test.log(LogStatus.FAIL, "Failed");
//		}
	}

}
