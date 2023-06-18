package com.guna;

import org.openqa.selenium.By;

import com.util.BaseClass;

public class Sel_09_RadioButtom extends BaseClass{
	public static String selectedBrowser = "";
	private void yourMostFavoriteBrowser() {
		driver.findElement(By.xpath("//*[@id='j_idt87:console1']/tbody/tr/td[4]/div/div[2]/span")).click();
		System.out.println("Your most favorite browser - Success");
	}
	
	private void unSelectable(String cityName) {
		String elePath = "//*[contains(text(),'"+cityName+"')]/../div/div[2]";
		System.out.println("elePath-> "+elePath);
		driver.findElement(By.xpath(elePath)).click();
		driver.findElement(By.xpath(elePath)).click();
		System.out.println("UnSelectable - Success");
	}
	
	public String findTheDefaultSelectRadioButton() {
		boolean chromeIsSelected = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
		boolean firefoxIsSelected = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
		boolean safariIsSelected = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
		boolean edgeIsSelected = driver.findElement(By.id("j_idt87:console2:3")).isSelected();
		System.out.println("chromeIsSelected-> "+chromeIsSelected);
		System.out.println("firefoxIsSelected-> "+firefoxIsSelected);
		System.out.println("safariIsSelected-> "+safariIsSelected);
		System.out.println("edgeIsSelected-> "+edgeIsSelected);
		if(chromeIsSelected==true)
			selectedBrowser="Chrome";
		else if(firefoxIsSelected==true)
			selectedBrowser="Firefox";
		else if(safariIsSelected==true)
			selectedBrowser="Safari";
		else if(edgeIsSelected==true)
			selectedBrowser="Edge";
		return selectedBrowser;
	}
	
	private void selectTheAgeGroupOnlyIfNotSelected() {
		boolean age1IsSelected = driver.findElement(By.id("j_idt87:age:0")).isSelected();
		if(age1IsSelected==false) {
			String age1 = driver.findElement(By.xpath("//*[@id='j_idt87:age:0']/ancestor::div[@class='ui-radiobutton ui-widget']/following-sibling::label")).getText();
			System.out.println(age1);
		}
		boolean age2IsSelected = driver.findElement(By.id("j_idt87:age:1")).isSelected();
		if(age2IsSelected==false) {
			String age2 = driver.findElement(By.xpath("//*[@id='j_idt87:age:1']/../../following-sibling::label")).getText();
			System.out.println(age2);
		}
		boolean age3IsSelected = driver.findElement(By.id("j_idt87:age:2")).isSelected();
		if(age3IsSelected==false) {
			String age3 = driver.findElement(By.xpath("//*[@id='j_idt87:age:2']/../../following-sibling::label")).getText();
			System.out.println(age3);
		}
	}
	
	public static void main(String[] args) {
		BaseClass bcl = new BaseClass();
		Sel_09_RadioButtom sel = new Sel_09_RadioButtom();
		String uRL = "https://leafground.com/radio.xhtml;jsessionid=node0ow7k8t5g2fr3weuxhw7oycjg311313.node0";
		String cityName = "Chennai";
		bcl.openURL(uRL);
		
		//Your most favorite browser
		sel.yourMostFavoriteBrowser();
		
		//UnSelectable
		sel.unSelectable(cityName);
		
		//Find the default select radio button
		sel.findTheDefaultSelectRadioButton();
		System.out.println(selectedBrowser+" is the selected browser.");
		
		//Select the age group (only if not selected)
		sel.selectTheAgeGroupOnlyIfNotSelected();
		driver.close();
	}

}
