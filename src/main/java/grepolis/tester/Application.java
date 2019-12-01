package grepolis.tester;

import grepolis.tester.po.GamePage;
import grepolis.tester.po.LoginPage;
import grepolis.tester.po.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Application {

    public static final String APPLICATION_NAME = "Grepolis Tester";
    public static final String FAREWELL = "Execution ended";
    public static final String SITE = "http://grepolis.com";
    public static final String USERNAME = "mattester@hotmail.com";
    public static final String PASSWORD = "test321";
    public static final String PLAYER_NAME = "Mat Tester";

    protected Logger log;

    public Application() {
        this.log = LoggerFactory.getLogger(this.getClass().getName());
    }

    public void execute() {
//        this.log.info(APPLICATION_NAME);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(SITE);
//        login(driver, USERNAME, PASSWORD);

        LoginPage loginPage = new LoginPage(driver);
        StartPage startPage = loginPage.performSuccessfullLogin(USERNAME, PASSWORD);

        log.info("Player Greeting: " + startPage.getPlayerGreeting().getText());
        log.info("World: " + startPage.getWorld().getText());

        GamePage gamePage = startPage.enterWorld();

        log.info("Town name: " + gamePage.getTownName().getText());
        log.info("Wood: " + gamePage.getResourceWood().getText());
        log.info("Stone: " + gamePage.getResourceStone().getText());
        log.info("Iron: " + gamePage.getResourceIron().getText());
        log.info("Population: " + gamePage.getPopulation().getText());

        log.info("Closing popup");
        gamePage.closePopUp();

        log.info("Create soldiers");
        gamePage.createSoldier();

        log.info("Open and Close the Senate");
        gamePage.openCloseSenate();

        gamePage.goToStrategicMap();
        gamePage.goToIsland();
        gamePage.goToCity();

        log.info(FAREWELL);
        driver.close();
    }

    public boolean login(WebDriver driver, String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("login_userid"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("login_password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login_Login"));
        loginButton.click();

        this.waitForLoad(driver);

        WebElement greeting = driver.findElement(By.className("player_greeting"));
        log.info("Greeting " + greeting.getText()   );

        return true;
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.execute();
    }
}
