package CanvasTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver	driver = new ChromeDriver();	
		driver.manage().window().maximize();	
		driver.get("http://www.htmlcanvasstudio.com/");
		
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		
		WebElement canvas = driver.findElement(By.id("imageView"));
		
		
		
		
		Point point = canvas.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
		Dimension size = canvas.getSize();
		System.out.println(size);
		Actions actions = new Actions(driver);
		
		actions.moveToElement(canvas, xcord, ycord).click().build().perform();
		
		actions.dragAndDropBy(canvas, 200, 0).clickAndHold().perform();
		actions.dragAndDropBy(canvas, 0, 200).clickAndHold().perform();
		driver.findElement(By.xpath("//input[@title='Draw a rectangle']")).click();
			
		actions.dragAndDropBy(canvas, 100, 100).clickAndHold().perform();
	}
}
