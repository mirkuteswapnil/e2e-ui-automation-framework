package pages;

import static org.junit.Assert.fail;   

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import elements.LandingPageElements;
import steps.AbstractBase;

import io.cucumber.datatable.DataTable;

public class LandingPage {
	
	WebDriver driver;
	AbstractBase base;
	LandingPageElements homeElements;
	private WebDriver webdriver;
	
	public LandingPage(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
		homeElements = new LandingPageElements(this.driver);
	}
		
	public void redirectToLandingPage()
	{
		String landingPageUrl = base.getLandingPageURL();
		driver.get(landingPageUrl);
	}
	
	public void addItemsToList(DataTable dt)
	{
		List<String> items = dt.asList(String.class);
	
		//System.out.println("Username - " + items.get(0));
		for(int i=0;i<items.size();i++)
		{
			homeElements.txtbx_ItemName.sendKeys(items.get(i));
			homeElements.txtbx_ItemName.sendKeys(Keys.ENTER);
		}
	}

	public void removeItemsFromList(DataTable dt)
	{
		List<String> itemsToRemove = dt.asList(String.class);
		int itemCnt = homeElements.allItemsInList.size();
		
		for(int k=0;k<itemsToRemove.size();k++)
		{
			for(int i=0;i<itemCnt;i++)
			{			
				if(homeElements.allItemsInList.get(i).getText().trim().equalsIgnoreCase(itemsToRemove.get(k)))
				{				
					Actions builder = new Actions(driver);
					builder.moveToElement(homeElements.allItemsInList.get(i)).perform();
					builder.moveToElement(homeElements.crossItemList.get(i)).click().perform();
					break;
				}
			}
		}
	}
	
	public void markItemsCompleted(DataTable dt)
	{
		List<String> itemsToComplete = dt.asList(String.class);
		int itemCnt = homeElements.allItemsInList.size();
		for(int k=0;k<itemsToComplete.size();k++)
		{
			for(int i=0;i<itemCnt;i++)
			{			
				if(homeElements.allItemsInList.get(i).getText().trim().equalsIgnoreCase(itemsToComplete.get(k)))
				{
					homeElements.chkBxList_complteItem.get(i).click();
					break;
				}
			}	
		}
	}
	
	public void clickSection(String sectionToClick)
	{
		int sectionCnt = homeElements.lnkList_section.size();
		for(int i=0;i<sectionCnt;i++)
		{			
			if(homeElements.lnkList_section.get(i).getText().trim().equalsIgnoreCase(sectionToClick))
			{
				homeElements.lnkList_section.get(i).click();
				break;
			}
		}	
	}
	
	public void verifyItemsInSection(String section, DataTable dt)
	{
		List<String> itemsToVerify = dt.asList(String.class);
		int actualItemsInListCnt =0;
		List<WebElement> actualItemsList = null; 
		String errorMsg ="";
		
		if(section.equalsIgnoreCase("Completed"))
		{
			actualItemsInListCnt = homeElements.lblList_itemsCompleted.size();
			actualItemsList = homeElements.lblList_itemsCompleted;
			errorMsg = "Item marked as completed is not present in completed section : ";
		}
		else if(section.equalsIgnoreCase("Active")) 
		{
			actualItemsInListCnt = homeElements.allItemsInList.size();
			actualItemsList = homeElements.allItemsInList;
			errorMsg = "Item not present in 'Active' section : ";			
		}
		else if(section.equalsIgnoreCase("All")) 
		{
			actualItemsInListCnt = homeElements.allItemsInList.size();
			actualItemsList = homeElements.allItemsInList;
			errorMsg = "Item not present in 'All' section : ";			
		}

		for(int k=0;k<itemsToVerify.size();k++)
		{
				boolean itemFound=false;
				for(int i=0;i<actualItemsInListCnt;i++)
				{			
					if(actualItemsList.get(i).getText().trim().equalsIgnoreCase(itemsToVerify.get(k)))
					{
						itemFound=true;
						break;
					}
				}
				if(itemFound==false)
					fail(errorMsg + itemsToVerify.get(k));
		}		
	}
	
	public void renameItems(DataTable dt)
	{
		List<Map<String, String>> itemDetailsList = dt.asMaps(String.class, String.class);
		for(int k=0; k<itemDetailsList.size(); k++) {
			System.out.println(itemDetailsList.get(k).get("From"));
			System.out.println(itemDetailsList.get(k).get("To"));
			
			for(int i=0;i<homeElements.allItemsInList.size();i++)
			{			
				if(homeElements.allItemsInList.get(i).getText().trim().equalsIgnoreCase(itemDetailsList.get(k).get("From")))
				{					
					Actions builder = new Actions(driver);
					builder.moveToElement(homeElements.allItemsInList.get(i)).perform();
					builder.moveToElement(homeElements.allItemsInList.get(i)).doubleClick().build().perform();
					
	
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					homeElements.allItemsInList.get(i).clear();
//					homeElements.allItemsInList.get(i).sendKeys(Keys.CONTROL + "a");
//					homeElements.allItemsInList.get(i).sendKeys(Keys.DELETE);
//					homeElements.allItemsInList.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a"),itemDetailsList.get(k).get("To"));
					
//					homeElements.allItemsInList.get(i).sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
//					homeElements.allItemsInList.get(i).sendKeys(Keys.BACK_SPACE); //delete it
//					homeElements.allItemsInList.get(i).sendKeys("newtext"); //enter new text
					homeElements.allItemsInList.get(i).sendKeys(Keys.BACK_SPACE);
					homeElements.allItemsInList.get(i).sendKeys(itemDetailsList.get(k).get("To"));
					homeElements.allItemsInList.get(i).sendKeys(Keys.ENTER);
				}
			}
		}
	}
	
	public void moveItems(String fromSection, String toSection, DataTable dt)
	{
		List<String> itemsToMove = dt.asList(String.class);
		
		if(fromSection.equalsIgnoreCase("Completed") && toSection.equalsIgnoreCase("Active"))
		{
			int completedItemsCnt = homeElements.lblList_itemsCompleted.size();
			for(int k=0;k<itemsToMove.size();k++)
			{
				for(int i=0;i<completedItemsCnt;i++)
				{			
					if(homeElements.lblList_itemsCompleted.get(i).getText().trim().equalsIgnoreCase(itemsToMove.get(k)))
					{
						homeElements.chkBxList_complteItem.get(i).click();
						break;
					}
				}
			}
		}
	}
	
	public void verifyAddedItemsInList(String expectedItemCnt)
	{		
		String actualItemCnt = homeElements.lbl_ItemCnt.getText();
		if (!expectedItemCnt.equals(actualItemCnt)) {
			fail("Actual items added in the list are incorrect : " + actualItemCnt);
		}

	}
	
	public void clearCompletedItems()
	{
		homeElements.lnk_clearCompleted.click();
	}
	
}