import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactUs {
    WebDriver driver;

    By clickContact = By.xpath("//div[@class=\"navbar-nav\"]/a");
    By inputName = By.id("validationCustom01");
    By inputEmail = By.id("validationCustom02");
    By inputMessage = By.id("validationCustom03");
    By clickButton = By.xpath("//div[@class=\"form-group\"]/button");


    @BeforeClass
    public void initialSetup() {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void navigateTo() throws InterruptedException {
        driver.get("https://momedia.netlify.app");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Movie url " + currentUrl);

        String baseUrl = "https://momedia.netlify.app";
        driver.get(baseUrl);

        clickContactUs(clickContact);
        Thread.sleep(3000);

        String fullName = "Zunayed Mahfuz";
        enterFullName(inputName, fullName);
        Thread.sleep(3000);

        String enterEmail = "str053mgr@gmail.com";
        validEmail(inputEmail, enterEmail);
        Thread.sleep(3000);

        String enterMessage = "This is Selenium testNG practice";
        validMessage(inputMessage, enterMessage);
        Thread.sleep(3000);

        clickSend(clickButton);

    }

    private void clickSend(By element) {
        driver.findElement(element).click();
    }

    private void validMessage(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    private void validEmail(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    private void enterFullName(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    private void clickContactUs(By element) {
        driver.findElement(element).click();
    }

}
