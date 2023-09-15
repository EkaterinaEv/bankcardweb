package ru.netology.web;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BankCardApiTest {
    private WebDriver driver;

//    ChromeOptions options = new ChromeOptions();
//       options.addArguments("--disable-dev-shm-usage");
//       options.addArguments("--no-sandbox");
//       options.addArguments("--headless");
//    driver = new ChromeDriver(options);

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

}
