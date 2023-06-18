package com.guna;

import org.openqa.selenium.By;

import com.util.BaseClass;

public class Sel_10_Checkbox extends BaseClass{
	
	private void basicCheckbox() {
		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']/div[2]")).click();
	}
	
	private void notification() {
		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt91']/div[2]")).click();
		//Checked
		String actMsg = driver.findElement(By.xpath("//*[@id='j_idt87:msg_container']/div/div/div[2]/span")).getText();
		if(actMsg.equals("Checked"))
			System.out.println("CheckBox is enabled with notification");
		else
			System.out.println("Notification is not displayed");
	}
	
	private void chooseYourFavoriteLanguage() {
		String languages = "Java/Python/Others";
		String[] split = languages.split("/");
		for (String language : split) {
			System.out.println(language);
			System.out.println("//*[contains(text(),'"+language+"')]/preceding-sibling::div");
			driver.findElement(By.xpath("//*[contains(text(),'"+language+"')]/preceding-sibling::div")).click();
		}
	}
	
	private void triStateCheckbox() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='j_idt87:ajaxTriState']/div[2]")).click();
		String actMsg1 = driver.findElement(By.xpath("//*[@id='j_idt87:id_container']/div/div/div[2]/p")).getText();
		if(actMsg1.contains("1"))
			System.out.println("Click 1 is verified");
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='j_idt87:ajaxTriState']/div[2]")).click();
		String actMsg2 = driver.findElement(By.xpath("//*[@id='j_idt87:id_container']/div/div/div[2]/p")).getText();
		if(actMsg2.contains("2"))
			System.out.println("Click 2 is verified");
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='j_idt87:ajaxTriState']/div[2]")).click();
		String actMsg3 = driver.findElement(By.xpath("//*[@id='j_idt87:id_container']/div/div/div[2]/p")).getText();
		if(actMsg3.contains("0"))
			System.out.println("Click 3 is verified");
	}
	
	private void toggleSwitch() {
		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt100']/div[2]")).click();
		String actMsg = driver.findElement(By.xpath("//*[@id='j_idt87:msg_container']/div/div/div[2]/span")).getText();
		if(actMsg.equals("Checked"))
			System.out.println("CheckBox is enabled with notification");
		else
			System.out.println("Notification is not displayed");
	}
	
	private void verifyIfCheckBoxIsDisabled() {
		boolean chkBxStatus = driver.findElement(By.id("j_idt87:j_idt102_input")).isEnabled();
		if(chkBxStatus==true)
			System.out.println("CheckBox is Enabled");
		else
			System.out.println("CheckBox is Disabled");
	}

	//*[contains(text(),'Miami')]/preceding-sibling::input
	private void selectMultiple() {
		driver.findElement(By.xpath("//*[@id='j_idt87:multiple']/ul")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Paris')]/preceding-sibling::div/div[2]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Rome')]/preceding-sibling::div/div[2]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Amsterdam')]/preceding-sibling::div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id='j_idt87:multiple']/ul")).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		BaseClass bcl = new BaseClass();
		Sel_10_Checkbox sel = new Sel_10_Checkbox();
		String uRL = "https://leafground.com/checkbox.xhtml";
		bcl.openURL(uRL);
		
		//Basic Checkbox
		sel.basicCheckbox();
		
		//Notification
		sel.notification();
		Thread.sleep(7000);
		//Choose your favorite language(s)
		sel.chooseYourFavoriteLanguage();
		
		//Tri State Checkbox
		sel.triStateCheckbox();
		
		Thread.sleep(10000);
		//Toggle Switch
		sel.toggleSwitch();
		
		//Verify if check box is disabled
		sel.verifyIfCheckBoxIsDisabled();
		
		//Select Multiple
		sel.selectMultiple();
		Thread.sleep(3000);
		
		driver.close();
	}

}
