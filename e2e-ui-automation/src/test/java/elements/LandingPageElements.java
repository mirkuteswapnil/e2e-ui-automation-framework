package elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPageElements {
	WebDriver driver;
	
	public LandingPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//header[@class='header']/input[@class='new-todo']") 
	 public WebElement txtbx_ItemName;
		
	@FindBy(how = How.XPATH, using = "//span[@class='todo-count']/strong") 
	 public WebElement lbl_ItemCnt;
		
	@FindBy(how = How.XPATH, using = "//div[@class='view']/label")
	 public WebElement itemInTheList;
	
	
	@FindBy(how = How.XPATH, using = "//ul[@class='todo-list']/li")
	 public List<WebElement> allItemsInList;

	@FindBy(how = How.XPATH, using = "//button[@class='destroy']")
	 public List<WebElement> crossItemList;

	@FindBy(how = How.XPATH, using = "//input[@class='toggle']")
	 public List<WebElement> chkBxList_complteItem;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='filters']/li/a")
	 public List<WebElement> lnkList_section;
		
	@FindBy(how = How.XPATH, using = "//ul[@class='todo-list']/li[@class='todo completed']")
	 public List<WebElement> lblList_itemsCompleted;
		
	@FindBy(how = How.XPATH, using = "//button[@class='clear-completed']")
	 public WebElement lnk_clearCompleted;
	
	
}
