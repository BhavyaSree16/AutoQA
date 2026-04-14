package pages;

import org.openqa.selenium.*;

public class SignupPage extends BasePage {

    private By signupLoginBtn = By.cssSelector("a[href='/login']");
    private By nameField = By.cssSelector("input[data-qa='signup-name']");
    private By emailField = By.cssSelector("input[data-qa='signup-email']");
    private By signupBtn = By.cssSelector("button[data-qa='signup-button']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void openSignupPage() {
        waitForElement(signupLoginBtn).click();
        waitForElement(nameField);
    }

    public void enterDetails(String name, String email) {

        WebElement nameEl = waitForElement(nameField);
        WebElement emailEl = waitForElement(emailField);

        nameEl.clear();
        nameEl.sendKeys(name);

        emailEl.clear();
        emailEl.sendKeys(email);
    }

    public void clickSignup() {
        waitForElement(signupBtn).click();
    }
}