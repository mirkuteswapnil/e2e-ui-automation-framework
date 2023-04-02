package pages;

import java.awt.AWTException; 
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import steps.AbstractBase;

public class Common {

	WebDriver driver;
	AbstractBase base;
	
	static int PAGE_LOAD_TIMEOUT = 20;
	static int IMPLICIT_WAIT = 30;
	
	String refID;
	
	public Common(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
	}

	public void navigateToPage(String url) {
		driver.get(url);
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
}
