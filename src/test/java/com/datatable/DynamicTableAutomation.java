package com.datatable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicTableAutomation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

		WebElement tableDataButton = driver.findElement(By.xpath("//summary[text()='Table Data']"));

		tableDataButton.click();

		WebElement inputTextBox = driver.findElement(By.id("jsondata"));
		String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
		inputTextBox.clear();

		inputTextBox.sendKeys(jsonData);

		WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));

		refreshTableButton.click();

		WebElement rows = driver.findElement(By.xpath("(//table[@id='dynamictable']//tr//td[1])[1]"));

		Assert.assertEquals("Bob", rows.getText());

		System.out.println("Assert verified successfully");

	}

}
