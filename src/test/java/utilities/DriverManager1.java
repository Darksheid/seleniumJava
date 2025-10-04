package utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager1 {
	@SuppressWarnings("deprecation")
	public static WebDriver createWebDriver(String browser) throws IOException, InterruptedException {
		WebDriver driver = null;
		WebDriverWait wait = null;
		WebDriverWait smallwait = null;
		try {
			String gridMode = "off";
			String downloadPath = System.getProperty("user.dir") + "\\download\\";
			System.out.println("Default Download path : " + downloadPath);

			// Clean existing files from directory is persists!!
			File folder = new File(downloadPath);
			FileUtils.cleanDirectory(folder);

			if (gridMode.contains("off")) {
				if (browser.equalsIgnoreCase("chrome")) {
					System.out.println("Chrome Started >> ");
					System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
					HashMap<String, Object> prefs = new HashMap<String, Object>();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					options.addArguments("--safebrowsing-disable-download-protection");
					options.addArguments("safebrowsing-disable-extension-blacklist");
					prefs.put("profile.default_content_settings.popups", 0);
					prefs.put("download.default_directory", downloadPath);
					prefs.put("download.prompt_for_download", true);
					prefs.put("safebrowsing.enabled", true);
					options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					options.addArguments("--start-maximized");
					// options.addArguments("--headless=new");
					options.setExperimentalOption("prefs", prefs);
					driver = new ChromeDriver(options);

					driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().deleteAllCookies();
					smallwait = new WebDriverWait(driver, 5);
					// driver.manage().window().maximize();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return driver;
	}

	public static void main(String[] args) throws Throwable {
	}
}