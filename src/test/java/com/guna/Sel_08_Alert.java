package com.guna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.util.BaseClass;

public class Sel_08_Alert extends BaseClass{
	public Alert alrt;
	private void alertSimpleDialog() {
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		alrt = driver.switchTo().alert();
		alrt.accept();
		boolean alertVerify = driver.findElement(By.id("simple_result")).getText().contains("successfully");
		if(alertVerify==true)
			System.out.println("Alert (Simple Dialog) - Success");
		else
			System.out.println("Alert (Simple Dialog) - Fail");
	}
	
	private void alertConfirmDialog() {
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		alrt=driver.switchTo().alert();
		alrt.accept();
		boolean okVerify = driver.findElement(By.xpath("//*[@id='result']")).getText().contains("OK");
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		alrt=driver.switchTo().alert();
		alrt.dismiss();
		boolean cancelVerify = driver.findElement(By.xpath("//*[@id='result']")).getText().contains("Cancel");
		if(okVerify==true && cancelVerify==true)
			System.out.println("Alert (Confirm Dialog) - Success");
		else
			System.out.println("Alert (Confirm Dialog) - Fail");
	}
	
	private void sweetAlertSimpleDialog() {
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		alrt=driver.switchTo().alert();
		driver.switchTo().d
		alrt.accept();
	}
	
	public static void main(String[] args) throws InterruptedException {
		BaseClass bcl = new BaseClass();
		Sel_08_Alert sel = new Sel_08_Alert();
		String uRL = "https://leafground.com/alert.xhtml";
		bcl.openURL(uRL);
		//Alert (Simple Dialog)
		sel.alertSimpleDialog();
		//Alert (Confirm Dialog)
		sel.alertConfirmDialog();
		//Sweet Alert (Simple Dialog)
		sel.sweetAlertSimpleDialog();
		Thread.sleep(5000);
		driver.close();
	}
}
