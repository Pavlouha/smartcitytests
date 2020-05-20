package com.pavlouha;

import java.io.IOException;

public class Main {
public static void main(String[] args) throws InterruptedException, IOException {
    //Внимание! Не забудьте поместить ваш вебдрайвер
    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
new WrongLogin().getWrongLogin();
new GoodLogin().getGoodLogin();
new ReportStateChange().testState();
new Redirection().testRedirection();
new Moderator().tryChangeUserState();
    new TestReport().sendReport();
new TestUser().sendUser();
    new Like().sendLike();
    new Comment().sendTestComment();
}
}
