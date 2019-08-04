package grepolis.tester.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends BasePage {

    @FindBy(className = "player_greeting")
    WebElement playerGreeting;

    @FindBy(className = "world_name")
    WebElement world;

    @FindBy(className = "logout_button")
    WebElement disconnectButton;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public GamePage enterWorld() {
        world.click();

        // TODO improve enterWorld
        try {
            Thread.currentThread().sleep(DEFAULT_WAIT_TIME * 1000);
        } catch (InterruptedException e) {
            return null;
        }
        WebElement myDynamicElement = (new WebDriverWait(driver, DEFAULT_WAIT_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("town_name")));

        return new GamePage(driver);
    }

    public WebElement getPlayerGreeting() {
        return playerGreeting;
    }

    public WebElement getWorld() {
        return world;
    }

    public WebElement getDisconnectButton() {
        return disconnectButton;
    }
}
