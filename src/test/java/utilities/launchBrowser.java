package utilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchBrowser {

	public static WebDriver specificDriver(String browser) {
		WebDriver driver = null;
		try {
			if (browser.equals("chrome")) {
				// WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", "..\\src\\test\\java\\webdrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Chrome Driver is launched succesfully");
			} else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Edge Driver is launched succesfully");
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("Firefox Driver is launched succesfully");
			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Error in launching the " + browser + " Driver");
			e.printStackTrace();
		}

		return driver;

	}

	public static WebDriver chromeDriver() {
		WebDriver driver = null;
		try {

			String path = System.getProperty("user.dir") + "\\webdrivers\\chromedriver.exe";
			String downloadFilepath = System.getProperty("user.dir") + "\\download\\";
			System.setProperty("webdriver.chrome.driver", path);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--safebrowsing-disable-download-protection");
			options.addArguments("safebrowsing-disable-extension-blacklist");
			HashMap<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", downloadFilepath);
			prefs.put("download.prompt_for_download", false);
			prefs.put("safebrowsing.enabled", true);
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments("--start-maximized");
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);

			System.out.println("Chrome Driver is launched succesfully");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in launching the chrome driver");
		}
		return driver;
	}

}
