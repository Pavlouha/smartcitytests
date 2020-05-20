package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Like {

    public void sendLike() throws IOException {
        System.out.println("Попытка лайкнуть одну жалобу несколько раз");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://seniorkot.com:8000/like/23/3");
            System.out.println("Лайк 1");
            System.out.println(driver.getPageSource());
            driver.get("http://seniorkot.com:8000/like/23/3");
            System.out.println("Лайк 2");
            System.out.println(driver.getPageSource());
        } finally {
            driver.quit();
        }

    }
}
