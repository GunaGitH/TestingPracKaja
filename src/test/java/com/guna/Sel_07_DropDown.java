package com.guna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.util.BaseClass;

public class Sel_07_DropDown extends BaseClass{

	private void favUI() {
		
		WebElement drp1 = driver.findElement(By.xpath("//*[@id='j_idt87']/div/div[1]/div[1]/div/div/select"));
		Select sel = new Select(drp1);
		sel.selectByIndex(1);
	}
	
	private void country() {
		driver.findElement(By.id("j_idt87:country_label")).sendKeys("India");;
//		WebElement drp2 = driver.findElement(By.id("j_idt87:country_input"));
//		Select sel = new Select(drp2);
//		sel.selectByValue("India");
	}
	public static void main(String[] args) {
		BaseClass bcl = new BaseClass();
		Sel_07_DropDown sel = new Sel_07_DropDown();
		String uRL = "https://leafground.com/select.xhtml";
		bcl.openURL(uRL);

		//Which is your favorite UI Automation tool?
		sel.favUI();
		
		//Choose your preferred country.
		sel.country();
		driver.close();
	}

}
