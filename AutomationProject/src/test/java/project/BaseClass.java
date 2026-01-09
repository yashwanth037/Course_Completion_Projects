package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class BaseClass {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void launchApp(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\yalag\\OneDrive\\Documents\\Jar File\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else {
            System.out.println("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get("https://qainterview.pythonanywhere.com/");
    }

    @AfterMethod
    public void closeApp() {
        driver.close();
    }
}
