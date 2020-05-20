package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Redirection {
    public void testRedirection() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://seniorkot.com:8000/all");
            System.out.println(driver.getCurrentUrl());
            driver.get("http://seniorkot.com:8000/all_user");
            System.out.println(driver.getCurrentUrl());
            driver.get("http://seniorkot.com:8000/all_like");
            System.out.println(driver.getCurrentUrl());
        }finally {
            driver.quit();
        }
    }
}
