import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SawgLabTest {

    WebDriver driver;

    @BeforeMethod
    public void browserOpen(){

        //web browser open and maximize
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com/");

    }


    @Test
    public void process() throws InterruptedException {

        //login
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();

        //confirm login
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title is " + actualTitle);
        }else{
            System.out.println("Title not same");
        }

        //select item and click
        WebElement itemSelect = driver.findElement(By.xpath("//a[@id=\"item_4_title_link\"]"));
        itemSelect.click();

        //click add to cart button
        WebElement clickBtn = driver.findElement(By.xpath("//button[@id=\"add-to-cart\"]"));
        clickBtn.click();

        //click to cart item button
        WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        addtoCart.click();

        //click checkout button
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

        //fill information
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Malinda");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Prabath");

        WebElement postCode = driver.findElement(By.id("postal-code"));
        postCode.sendKeys("61610");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        //click the finish button
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        Thread.sleep(3000);

//        //click to back to home button
        WebElement backHome = driver.findElement(By.id("back-to-products"));
        backHome.click();
//
//        //log out process
//        WebElement manu = driver.findElement(By.id("react-burger-menu-btn"));
//        manu.click();
//
//        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
//        logOut.click();






    }

}
