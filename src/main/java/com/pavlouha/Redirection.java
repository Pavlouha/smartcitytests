package com.pavlouha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Redirection {
    public void testRedirection() {
        System.out.println("Невозможность просмотра без регистрации");
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
