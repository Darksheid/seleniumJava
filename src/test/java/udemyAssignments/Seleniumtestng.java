package udemyAssignments;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Seleniumtestng {

  public WebDriver driver=null;

  @BeforeTest
  public void browserSetup(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    System.out.println("Browser Setup done");
  }

	@Test(groups={"include-test-two"})
  public void wikip(){
    driver.get("https://www.wikipedia.org/");
    driver.findElement(By.xpath("//*[text()='Google Play Store']")).click();
    String currpage = driver.getWindowHandle();
    Iterator<String> i = driver.getWindowHandles().iterator();
    while(i.hasNext()){
      String childpage = i.next();
      if(!childpage.equals(currpage))
        driver.switchTo().window(childpage);
    }
    System.out.println(driver.getTitle());

  }

  @Test(groups={"include-test-one"})
  public void dragDrop(){
    driver.get("http://localhost:8000/");
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
    WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
    Actions ac = new Actions(driver);
    ac.dragAndDrop(draggable,droppable);
    WebElement dropstatus = driver.findElement(By.xpath("//p[@id='dropStatus']"));
    System.out.println(dropstatus.getText());

  }

  @Test(groups={"test-one-exclude"})
  public void dummyOne(){

  }

  @Test(groups={"test-two-exclude"})
  public void dummyTwo(){
    
  }

  @AfterTest
  public void tearDown(){
    driver.quit();
  }


}
