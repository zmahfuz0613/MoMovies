import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchMovies {

    WebDriver driver;
    By firstMovieSelector = By.xpath("//*[@id=\"basic-navbar-nav\"]/form/span/div/ul/li[1]//a");
    By searchInput = By.id("search-input");
    By actorInfo = By.xpath("//div[@class=\"card-body\"]/button/h5[contains(text(),'Bruce Willis')]");

    @BeforeClass
    public void initialSetup() {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void moMediaSearch() throws InterruptedException {
        driver.get("https://momedia.netlify.app");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Movie url " + currentUrl);

        String baseUrl = "https://momedia.netlify.app";
        driver.get(baseUrl);

        String movieName = "Hard Kill";
        enterText(searchInput, movieName);

        clickElement(firstMovieSelector);
        Thread.sleep(3000);

        clickActorElement(actorInfo);
        Thread.sleep(3000);

    }

    private void clickElement(By element) {
        driver.findElement(element).click();
    }
    private void enterText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    private void clickActorElement(By element) {
        driver.findElement(element).click(); //click on actor name
    }

}


