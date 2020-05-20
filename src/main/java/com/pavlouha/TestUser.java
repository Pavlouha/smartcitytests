package com.pavlouha;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestUser {

    public void sendUser() throws IOException {
        System.out.println("Попытка отправки пользователя");
        URL url = new URL ("http://seniorkot.com:8000/insert_user");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        String jsonInputString = "name=test_test&email=test@mail.ru&hash=1001&role=user";
        System.out.println(jsonInputString);
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://seniorkot.com:8000/login/");
            driver.findElement(By.name("email")).sendKeys("pkesler30@gmail.com");
            driver.findElement(By.name("pass")).sendKeys("qwerty" + Keys.ENTER);
            driver.navigate().to("http://seniorkot.com:8000/all_user?sort=-id");
            WebElement firstResult = wait.until(presenceOfElementLocated(By.className("even")));
            System.out.println("На сервере");
            System.out.println(firstResult.getText());
        } finally {
            driver.quit();
        }

    }
}
