package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class googlePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public googlePage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='lnXdpd']")
	private WebElement glg_img;
	
	@FindBy(xpath="//textarea[@title='Search']")
	private WebElement txtBox;

	@FindBy(xpath="//div[@class='lJ9FBc']//input[@value='Google Search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//div[@id='result-stats']")
	private WebElement div_res;
	
	@FindBy(xpath="//*[contains(text(),'Virat Kohli')]")
	private List<WebElement> glgRes;
	
	public boolean navigateGooglePage(String url) throws InterruptedException {
		boolean res=false;
		try {
			System.out.println("Launching Google Homepage----------------");
			driver.get(url);
			wait.until(ExpectedConditions.visibilityOf(glg_img));
			System.out.println("Google Homepage is launched sucessfully!!");
			res=true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to navigate Google Page!!");
		}
		
		return res;

	}
	
	public boolean searchText(String keyword) {
		boolean res=false;
		try {
			txtBox.click();
			txtBox.sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOf(searchBox));
			searchBox.click();
			res=true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to search");
		}
		return res;
	}
	
	public boolean validateSearch() {
		boolean res=false;
		try {
			
			wait.until(ExpectedConditions.visibilityOf(div_res));
			if(glgRes.size()>0) {
				System.out.println("Result found successfully!!");
				res=true;
			}else {
				System.out.println("Result NOT found!!");
				res=false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception while scanning the elements!!");
		}
		return res;
	}
	
	public boolean download(String url) {
		driver.get(url);
		WebElement downloadBtn = driver.findElement(By.xpath("(//a[text()='Windows installer (64-bit)'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(downloadBtn)); 
		downloadBtn.click();
		return true;
	}

}
