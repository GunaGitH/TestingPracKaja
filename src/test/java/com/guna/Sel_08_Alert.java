package com.guna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.util.BaseClass;

public class Sel_08_Alert extends BaseClass {
	public Alert alrt;

	private void alertSimpleDialog() {
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		alrt = driver.switchTo().alert();
		alrt.accept();
		boolean alertVerify = driver.findElement(By.id("simple_result")).getText().contains("successfully");
		if (alertVerify == true)
			System.out.println("Alert (Simple Dialog) - Success");
		else
			System.out.println("Alert (Simple Dialog) - Fail");
	}

	private void alertConfirmDialog() {
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		alrt = driver.switchTo().alert();
		alrt.accept();
		boolean okVerify = driver.findElement(By.xpath("//*[@id='result']")).getText().contains("OK");
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		alrt = driver.switchTo().alert();
		alrt.dismiss();
		boolean cancelVerify = driver.findElement(By.xpath("//*[@id='result']")).getText().contains("Cancel");
		if (okVerify == true && cancelVerify == true)
			System.out.println("Alert (Confirm Dialog) - Success");
		else
			System.out.println("Alert (Confirm Dialog) - Fail");
	}

	private void sweetAlertSimpleDialog() {
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		driver.findElement(By.id("j_idt88:j_idt98")).click();
		if(driver.getTitle().equals("Alert"))
			System.out.println("Sweet Alert (Simple Dialog) - Success");
		else
			System.out.println("Sweet Alert (Simple Dialog) - Fail");
	}

	private void sweetModalDialog() {
		driver.findElement(By.id("j_idt88:j_idt100")).click();
		//driver.findElement(By.xpath("//*[@ID='j_idt88:j_idt101_title']/following-sibling::a")).click();
		//*[@id='j_idt88:j_idt101']/div[1]/a/span
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt101']/div[1]/a/span")).click();
		if(driver.getTitle().equals("Alert"))
			System.out.println("Sweet Modal Dialog - Success");
		else
			System.out.println("Sweet Modal Dialog - Fail");
	}
	
	private void alertPromptDialog() throws InterruptedException {
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		Thread.sleep(3000);
		al.sendKeys("Hello");
		al.accept();
		//*[@id="confirm_result"]
		String actConfirmation = driver.findElement(By.id("confirm_result")).getText();
		System.out.println("actConfirmation-> "+actConfirmation);
		if(actConfirmation.contains("Hello"))
			System.out.println("Alert (Prompt Dialog) - Success");
		else
			System.out.println("Alert (Prompt Dialog) - Fail");
	}
	
	private void sweetAlertConfirmation() {
		driver.findElement(By.id("j_idt88:j_idt106")).click();
		driver.findElement(By.id("j_idt88:j_idt108")).click();
		driver.findElement(By.id("j_idt88:j_idt106")).click();
		driver.findElement(By.id("j_idt88:j_idt109")).click();
		if(driver.getTitle().equals("Alert"))
			System.out.println("Sweet Alert (Confirmation) - Success");
		else
			System.out.println("Sweet Alert (Confirmation) - Fail");
	}
	
	private void minimizeAndMaximize() {
		driver.findElement(By.id("j_idt88:j_idt111")).click();
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt112']/div[1]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt112']/div[1]/a[3]")).click();
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt112']/div[1]/a[1]")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		BaseClass bcl = new BaseClass();
		Sel_08_Alert sel = new Sel_08_Alert();
		String uRL = "https://leafground.com/alert.xhtml";
		bcl.openURL(uRL);
		// Alert (Simple Dialog)
		sel.alertSimpleDialog();
		// Alert (Confirm Dialog)
		sel.alertConfirmDialog();
		// Sweet Alert (Simple Dialog)
		sel.sweetAlertSimpleDialog();
		// Sweet Modal Dialog
		//sel.sweetModalDialog();
		//Alert (Prompt Dialog)
		sel.alertPromptDialog();
		//Sweet Alert (Confirmation)
		sel.sweetAlertConfirmation();
		//Minimize and Maximize
		sel.minimizeAndMaximize();
		Thread.sleep(5000);
		driver.close();
	}
}
