package com.pavlouha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrongLogin {

    public void getWrongLogin() throws InterruptedException {
        System.out.println("Неправильный логин");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://seniorkot.com:8000/login/");
            driver.findElement(By.name("email")).sendKeys("jlegjldgj@ffkf");
            driver.findElement(By.name("pass")).sendKeys("jldff" + Keys.ENTER);
            Thread.sleep (5000);
        }finally {
            driver.quit();
        }
    }
}
