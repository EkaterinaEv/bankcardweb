//package ru.netology.web;
//
//import com.codeborne.selenide.SelenideElement;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import static com.codeborne.selenide.Condition.exactText;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//
//
//public class BankCardApiTest {
//    private WebDriver driver;
//    @BeforeAll
//    public void setupAll() {
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//        driver.get("http://localhost:9999");
//    }
//
//    @AfterEach
//    void tearDown() {
//        driver.quit();
//        driver = null;
//    }
//
//    @Test
//    void getPageTest(){
//        driver.get("http://localhost:9999");
//    }
//
//    @Test
//    void shouldTest() {
//        open("http://localhost:9999");
//        SelenideElement form = $("[data-test-id=callback-form]");
//        form.$("[data-test-id=name] input").setValue("Екатерина");
//        form.$("[data-test-id=phone] input").setValue("+79110000000");
//        form.$("[data-test-id=agreement]").click();
//
//        $(".alert-success").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
//    }
//}
