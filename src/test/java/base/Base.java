package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class Base {
	
public static Properties prop = new Properties();
public static WebDriver driver;
	
	
	public Base() {
		try {
			
		FileInputStream file = new FileInputStream("C:\\Users\\vikra\\OneDrive\\Desktop\\Tania\\Java workspace\\AmazonFinalProject\\src\\test\\java\\environmentvariables\\config.properties");
		prop.load(file);
	
	}
		catch(FileNotFoundException a) {
			a.printStackTrace();
		}
	
	catch(IOException e) {
		e.printStackTrace();
	}

	}
	public static void initiation() {
		String browsername=   prop.getProperty("browser");
		
		if(browsername.equals("Firefox")) {
		//	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
			else if (browsername.equals("Chrome")) {
		//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver= new ChromeDriver();
			}
			
			driver.manage().window().maximize();
		System.out.println(prop.getProperty("URL"));
			driver.manage().timeouts().pageLoadTimeout(TimeUtils.timewait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));
			
		}
	

}
