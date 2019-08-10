package grepolis.tester.po;

import org.openqa.selenium.By;
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

    @FindBy(name = "strategic_map")
    WebElement strategicMapButton;

    @FindBy(name = "island_view")
    WebElement islandViewButton;

    @FindBy(name = "city_overview")
    WebElement cityOverviewButton;

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public void goToStrategicMap() {
        this.strategicMapButton.click();
        this.wait(2);
    }

    public void goToIsland() {
        this.islandViewButton.click();
        this.wait(2);
    }

    public void goToCity() {
        this.cityOverviewButton.click();
        this.wait(2);
    }

    public void wait(int seconds) {
        try {
            Thread.currentThread().sleep(seconds * 1000);
        } catch(Exception e) {

        }
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
