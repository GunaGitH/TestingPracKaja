package com.kaja;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.guna.Sel_05_TextBox;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxPractice extends Sel_05_TextBox {

	private void slider() {
		//int oldAxisSlider = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/span")).getLocation().getX();
		int oldAxisSlider = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/span")).getLocation().getX();
		//driver.findElement(By.id("j_idt106:slider")).sendKeys("51");
		//int newAxisSlider = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/span")).getLocation().getX();

		System.out.println(oldAxisSlider);
		//System.out.println(newAxisSlider);

	}
	
	private void keyboard() {
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		boolean keyboardCheck = driver.findElement(By.xpath("/html/body/div[4]/div[1]/button[1]")).isEnabled();
		System.out.println(keyboardCheck);

	}

	public static void main(String[] args) throws InterruptedException {
		TextBoxPractice tbp = new TextBoxPractice();

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/input.xhtml;jsessionid=node02uc5y9pro8pl1l7ijc6l5lft2291941.node0");
		driver.findElement(By.id("j_idt88:name")).sendKeys("Kaja Mohideen");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys(" - Europe");
		boolean checkEnable = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		if (checkEnable == false)
			System.out.println("Text box is Disabled");
		else
			System.out.println("Text box is enabled");
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		String retText = driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value");
		System.out.println(retText);

		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("kajakasim10@gmail.com", Keys.TAB);
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("This is kaja mohideen from chennai");
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt103_editor\"]/div[1]")).sendKeys("NIl");
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		String errorMsg = driver.findElement(By.id("j_idt106:thisform:j_idt110_error-detail")).getText();
		if (errorMsg.equals("Age is mandatory"))
			System.out.println("Error msg is correct");
		else
			System.out.println("Error msg is notcorrect");

		int oldYAxis = driver.findElement(By.id("j_idt106:j_idt113")).getLocation().getY();

		Thread.sleep(3000);
		driver.findElement(By.id("j_idt106:float-input")).click();
		Thread.sleep(3000);
		int newYAxis = driver.findElement(By.id("j_idt106:j_idt113")).getLocation().getY();
		System.out.println("oldYAxis-" + oldYAxis + "  newYAxis-" + newYAxis);

		if (oldYAxis != newYAxis)
			System.out.println("Lable axis is changing");
		else
			System.out.println("Lable axis is notchanging");

		// driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("kaja");
		// driver.findElement(By.xpath("//*[@id='j_idt106:auto-complete_panel']/ul/li[3]")).click();
		// driver.findElement(By.xpath("//*[@id='j_idt106:auto-complete_input']")).sendKeys("Kaja");
		// driver.findElement(By.xpath("//*[@id='j_idt106:auto-complete_panel']/ul/li[3]")).click();

		String dob = "13/05/1995";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement dobEle = driver.findElement(By.id("j_idt106:j_idt116_input"));
		js.executeScript("arguments[0].setAttribute('value','" + dob + "')", dobEle);
		Object actdob = js.executeScript("return arguments[0].getAttribute('value')", dobEle);
		String expdob = dob;

		boolean verifyDob = actdob.equals(expdob);
		if (verifyDob == true)
			System.out.println("Dob is same");
		else
			System.out.println("Dob is not same");

		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\'j_idt106:j_idt118\']/a[1]/span")).click();
		String actNum = driver.findElement(By.id("j_idt106:j_idt118_input")).getAttribute("aria-valuenow");
		System.out.println(actNum);
		if (actNum != "2")
			System.out.println("Number is changerd");
		else
			System.out.println("Number is not changed");
		
		//int oldAxisSlider = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/span")).getLocation().getX();
				int oldAxisSlider = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/span")).getLocation().getX();
				driver.findElement(By.id("j_idt106:slider")).sendKeys("51");
				int newAxisSlider = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/span")).getLocation().getX();

				System.out.println("OldAxis Slider "+oldAxisSlider);
				System.out.println("Newaxis Slider "+newAxisSlider);
		
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		boolean keyboardCheck = driver.findElement(By.xpath("/html/body/div[4]/div[1]/button[1]")).isEnabled();
		if (keyboardCheck==true)
			System.out.println("it is enable");
		else 
			System.out.println("it is not enable");
		//driver.findElement(By.xpath("/html/body/div[4]/div[1]/button[13]")).click();
		
		
		//custome toolbar
		
		driver.findElement(By.xpath("//*[@id='j_idt106:j_idt124_toolbar']/span[1]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='j_idt106:j_idt124_editor']/div[1]")).sendKeys("Kaja Mohideen");
		
		
		
		// Slider
		//tbp.slider();
		
		// KEyboard Enable 
		
		//tbp.keyboard();
		
		

	}

}
