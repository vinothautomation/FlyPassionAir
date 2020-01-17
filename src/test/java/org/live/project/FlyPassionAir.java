package org.live.project;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlyPassionAir {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\AirLine\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://flypassionair.com/");
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File s1 = tk.getScreenshotAs(OutputType.FILE);
		File d1 = new File ("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\AirLine\\screensaver\\url.jpeg");
		FileUtils.copyFile(s1, d1);
		
		driver.findElement(By.xpath("//*[@id=\"depPort\"]/optgroup/option[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"arrPort\"]/optgroup/option[1]")).click();
		
		WebElement travelDate = driver.findElement(By.xpath("//*[@id=\"departureDate\"]"));
		travelDate.sendKeys(getData(6,4));
		travelDate.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"adult\"]/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();
		
		WebElement flightSelectBtn = driver.findElement(By.xpath("//*[@id=\"j_idt2500:3:j_idt2565\"]/div[3]/button"));
		Actions acc = new Actions(driver);
		acc.contextClick(flightSelectBtn).perform();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String x : child) {
		driver.switchTo().window(x);
		}
		
		File s3 = tk.getScreenshotAs(OutputType.FILE);
		File d3 = new File ("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\AirLine\\screensaver\\windowshandle.jpeg");
		FileUtils.copyFile(s3, d3);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"j_idt2500:3:j_idt2565\"]/div[3]/button")).click();
		
		File s4 = tk.getScreenshotAs(OutputType.FILE);
		File d4 = new File ("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\AirLine\\screensaver\\basketclick.jpeg");
		FileUtils.copyFile(s4, d4);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"basket\"]/div[3]/div[1]/div[2]/div[1]/span/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"gender1\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"name1\"]")).sendKeys(getData(3,4));
		driver.findElement(By.xpath("//*[@id=\"surname1\"]")).sendKeys(getData(4,4));
		driver.findElement(By.xpath("//*[@id=\"bday_day_1\"]/option[29]")).click();
		driver.findElement(By.xpath("//*[@id=\"bday_month_1\"]/option[11]")).click();
		driver.findElement(By.xpath("//*[@id=\"bday_year_1\"]/option[22]")).click();
		driver.findElement(By.xpath("//*[@id=\"gender2\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"name2\"]")).sendKeys(getData(5,4));
		driver.findElement(By.xpath("//*[@id=\"surname2\"]")).sendKeys(getData(4,4));
		driver.findElement(By.xpath("//*[@id=\"frst-tel-number0\"]")).sendKeys(getData(7,4));
		driver.findElement(By.xpath("//*[@id=\"email0\"]")).sendKeys(getData(8,4));
		
		File s5 = tk.getScreenshotAs(OutputType.FILE);
		File d5 = new File ("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\AirLine\\screensaver\\passengeridentification.jpeg");
		FileUtils.copyFile(s5, d5);
		
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"seatMenuOpenLink\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"SEAT_2A\"]")).click();
		
		File s6 = tk.getScreenshotAs(OutputType.FILE);
		File d6 = new File ("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\AirLine\\screensaver\\seatselectionconform.jpeg");
		FileUtils.copyFile(s6, d6);
		
		driver.findElement(By.xpath("//*[@id=\"addSSRContinueBTn\"]")).click();
		
		WebElement flightName = driver.findElement(By.xpath("//*[@id=\"paymentOptionsblock\"]/div[2]/div[3]/div[4]/div[1]"));
		String t1 = flightName.getText();
		System.out.println(t1);
		
		WebElement flightTotalFare = driver.findElement(By.xpath("//*[@id=\"totalPaymentAmount\"]/h3/span"));
		String t2 = flightTotalFare.getText();
		System.out.println(t2);

		File loc1 = new File("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\FlyPassionAir\\testdatas\\FlyPassionAir.xlsx");
		FileInputStream stm = new FileInputStream (loc1);
		Workbook w1 = new XSSFWorkbook(stm);
		Sheet s28 = w1.createSheet("AirLine Details");
		Row r1 = s28.createRow(13);
		Cell c1 = r1.createCell(4);
		String stringCellValue = c1.getStringCellValue();
		if (stringCellValue.equals("1")) {
		c1.setCellValue(t2);	
	}
		FileOutputStream o = new FileOutputStream(loc1);
		w1.write(o);
		System.out.println("Sucessfull");
		}
	public static String getData(int rowNo, int cellNo) throws Throwable {
		String v = null;
		File loc = new File("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\FlyPassionAir\\testdatas\\FlyPassionAir.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("AirLine Details");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell( cellNo );
		
		v = c.getStringCellValue();
		return v;
	}}
	
	


