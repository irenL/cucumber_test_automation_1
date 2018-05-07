package com.app.step_definition;

import java.util.List;

import com.app.beans.ContactBean;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.java.en.When;

public class CreateContactBeansStepDefs {

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateContactPage createContactPage = new SuiteCRMCreateContactPage();
	
	
	@When("^I save a new contact:$")
	public void i_save_a_new_contact(List<ContactBean> contacts) {
		
	    System.out.println(contacts.size());
	    
	    ContactBean contactBean = contacts.get(0);
	   
	    BrowserUtils.hover(dashboardPage.linkCreate);
	    dashboardPage.linkCreateContact.click();
	    // enter data
	    BrowserUtils.waitFor(3);
	    createContactPage.firstName.sendKeys(contactBean.getFirstName());
	    createContactPage.lastName.sendKeys(contactBean.getLastName());
	    createContactPage.officePhoneNumber.sendKeys(contactBean.getOfficePhone());
	    createContactPage.cellPhone.sendKeys(contactBean.getCellPhone());
	    createContactPage.department.sendKeys(contactBean.getDepartment());
	    createContactPage.email.sendKeys(contactBean.getEmail());
	    
	    
	    
	    
	    
	}
	
	
	
}
