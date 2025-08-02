package practice;

public class mytests {

	public static void main(String[] args) {
		// String month = "07";
		// String date = "21";
		// String year = "2024";
		//
		// System.setProperty("webdriver.chrome.driver",
		// "F:\\Projects\\revision\\src\\test\\java\\webdrivers\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebElement open_calender = driver.findElement(
		// By.xpath("//button[@class='react-date-picker__calendar-button
		// react-date-picker__button']"));
		// open_calender.click();

		// System.out.println(isRightAngled(3, 4, 5));
		String vowels = "aeiou";
		vowels.toUpperCase();
		System.out.println(vowels.substring(1, 2));
		// char ch = 'u';
		// for (int i = 0; i < 5; i++)
		// if (ch == vowels.charAt(i))
		// System.out.println(ch);

	}

	public static boolean isRightAngled(int side1, int side2, int side3) {
		// write your code
		if (side1 > 0 && side2 > 0 && side3 > 0) {
			int[] arr = { side1, side2, side3 };
			int maxVal = arr[0];
			int minVal = arr[0];
			for (int i : arr) {
				if (maxVal < i)
					maxVal = i;
				if (minVal > i)
					minVal = i;
			}
			int p = side1 + side2 + side3;
			int h = maxVal;
			int side = p - h - minVal;

			System.out.println(h + " " + minVal + " " + side);

			if (h * h == minVal * minVal + side * side)
				return true;
		}

		return false;
	}

}
