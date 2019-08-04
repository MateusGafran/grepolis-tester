package grepolis.tester.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(className = "main-title")
    WebElement title;
    @FindBy(id = "login_userid")
    WebElement username;
    @FindBy(id = "login_password")
    WebElement password;
    @FindBy(id = "login_Login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public StartPage performSuccessfullLogin(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();

//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("/html/body")).isDisplayed() );

        // TODO improve login
        WebElement myDynamicElement = (new WebDriverWait(driver, DEFAULT_WAIT_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("player_greeting")));

        return new StartPage(driver);
    }

}
