package grepolis.tester.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BasePage {

    @FindBy(className = "town_name")
    WebElement townName;

    @FindBy(className = "wood")
    WebElement resourceWood;

    @FindBy(className = "stone")
    WebElement resourceStone;

    @FindBy(className = "iron")
    WebElement resourceIron;

    @FindBy(className = "population")
    WebElement population;

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTownName() {
        return townName;
    }

    public WebElement getResourceWood() {
        return resourceWood;
    }

    public WebElement getResourceStone() {
        return resourceStone;
    }

    public WebElement getResourceIron() {
        return resourceIron;
    }

    public WebElement getPopulation() {
        return population;
    }
}
