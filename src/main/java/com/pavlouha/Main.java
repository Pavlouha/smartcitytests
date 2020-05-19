package com.pavlouha;

public class Main {
public static void main(String[] args) throws InterruptedException {
    //Внимание! Не забудьте поместить ваш вебдрайвер
    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
new WrongLogin().getWrongLogin();
new GoodLogin().getGoodLogin();
}
}
