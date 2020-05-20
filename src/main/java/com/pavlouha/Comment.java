package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Comment {

    public void sendTestComment() throws IOException {
        System.out.println("Попытка отправки комментария");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://seniorkot.com:8000/comment/3/23?text=test");
            driver.navigate().to("http://seniorkot.com:8000/comment?sort=-id");
            WebElement firstResult = wait.until(presenceOfElementLocated(By.className("even")));
            System.out.println("На сервере");
            System.out.println(firstResult.getText());
        } finally {
            driver.quit();
        }

    }

}
