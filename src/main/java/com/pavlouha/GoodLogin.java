package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GoodLogin {

    public void getGoodLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://seniorkot.com:8000/login/");
            driver.findElement(By.name("email")).sendKeys("pkesler30@gmail.com");
            driver.findElement(By.name("pass")).sendKeys("qwerty" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.name("PreviousReceiver")));
            //Если логин успешен, вывод состояний жалобы
            System.out.println(firstResult.getText());
            Thread.sleep(5000);
        }finally {
            driver.quit();
        }
    }

}
