package practice;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mytests {
	
	public static void main(String[] args) {
		String month = "07";
		String date = "21";
		String year ="2024";
		
		System.setProperty("webdriver.chrome.driver",
				"F:\\Projects\\revision\\src\\test\\java\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement open_calender = driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']"));
		open_calender.click();
		
		
		
	}

}
