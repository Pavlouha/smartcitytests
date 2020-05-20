package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ReportStateChange {
    public void testState() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://seniorkot.com:8000/login/");
            driver.findElement(By.name("email")).sendKeys("pkesler30@gmail.com");
            driver.findElement(By.name("pass")).sendKeys("qwerty" + Keys.ENTER);
            driver.navigate().to("http://seniorkot.com:8000/all?sort=-status");
            Select select = new Select(driver.findElement(By.tagName("select")));
select.selectByValue("16_3");
            Thread.sleep(5000);
            driver.navigate().to("http://seniorkot.com:8000/all?sort=status");
            Thread.sleep(1000);
            Select select2 = new Select(driver.findElement(By.tagName("select")));
            WebElement firstResult = wait.until(presenceOfElementLocated(By.className("even")));
            System.out.println(firstResult.getText());
            select2.selectByValue("16_1");
            WebElement secondResult = wait.until(presenceOfElementLocated(By.className("even")));
            System.out.println(secondResult.getText());
        }finally {
            driver.quit();
        }
    }
}
