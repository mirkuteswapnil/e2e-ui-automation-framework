package steps;

//import org.openqa.selenium.WebDriver;   
//import com.singtel.pages.Common;
import pages.LandingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TodoSteps {
	
	LandingPage dpLandingPage;
	
	public TodoSteps(LandingPage dpLandingPage) {
		this.dpLandingPage = dpLandingPage;
	}
	
	@Given("I am on todoMVC landing page")
	public void redirect_ToLandingPage() {
		dpLandingPage.redirectToLandingPage();
	}
	
	@When("I add following items in todo list:")
	public void addItems_ToList(DataTable dataTable) {
		//List<String> list = dt.asList(String.class);
		//dpLandingPage.addItemsToList(dataTable.row(0).get(0),dataTable.row(1).get(0),dataTable.row(2).get(0));
		dpLandingPage.addItemsToList(dataTable);
	}

	@When("I remove following items from todo list")
	public void removeItems_FromList(DataTable dataTable) {
		//List<String> list = dt.asList(String.class);
		//dpLandingPage.addItemsToList(dataTable.row(0).get(0),dataTable.row(1).get(0),dataTable.row(2).get(0));
		dpLandingPage.removeItemsFromList(dataTable);
	}
	
	@When("I mark following items as completed from todo list")
	public void markItems_Completed(DataTable dataTable) {
		//List<String> list = dt.asList(String.class);
		//dpLandingPage.addItemsToList(dataTable.row(0).get(0),dataTable.row(1).get(0),dataTable.row(2).get(0));
		dpLandingPage.markItemsCompleted(dataTable);
	}
	
	@When("I click on {string} section")
	public void click_OnSection(String section)
	{
		dpLandingPage.clickSection(section);
	}
	
	@When("I move following items from {string} to {string} section")
	public void move_Items(String fromSection, String toSection, DataTable datatable)
	{
		dpLandingPage.moveItems(fromSection, toSection, datatable);
	}
	
	@Then("I expect following items to be available in {string} section")
	public void verifyItems_InSection(String section, DataTable dataTable)
	{
		dpLandingPage.verifyItemsInSection(section, dataTable);
	}

	@When("I rename following items in todo list")
	public void rename_Items(DataTable dataTable)
	{
		dpLandingPage.renameItems(dataTable);
	}
	@Then("I expect {string} items added in the todo list")
	public void verify_ItemsInList(String cnt) {	
		dpLandingPage.verifyAddedItemsInList(cnt);
	}
	
	@When("I clear completed items")
	public void clear_completedItems()
	{
		dpLandingPage.clearCompletedItems();
	}
	
}
