package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Moderator {

    public void tryChangeUserState() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Логин как модератор, попытка изменения роли");
            driver.get("http://seniorkot.com:8000/login/");
            driver.findElement(By.name("email")).sendKeys("pkesler30@gmail.com");
            driver.findElement(By.name("pass")).sendKeys("qwerty" + Keys.ENTER);
            driver.navigate().to("http://seniorkot.com:8000/all_user?sort=role");
            WebElement firstResult = wait.until(presenceOfElementLocated(By.className("even")));
            System.out.println(firstResult.getText());
            Select select = new Select(driver.findElement(By.tagName("select")));
            select.selectByValue("6_1");
            driver.navigate().to("http://seniorkot.com:8000/all_user?sort=role");
            System.out.println("Изменённая роль");
            WebElement secondResult = wait.until(presenceOfElementLocated(By.className("even")));
            System.out.println(secondResult.getText());
            Thread.sleep(3000);
        }finally {
            driver.quit();
        }
    }

}
