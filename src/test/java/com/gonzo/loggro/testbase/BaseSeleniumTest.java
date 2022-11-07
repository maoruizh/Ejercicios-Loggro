package com.gonzo.loggro.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gonzo.loggro.login.LoginPage;

public class BaseSeleniumTest {
    protected WebDriver driver;
    protected static WebDriverWait wait;
    
    public static String URL_BASE = "https://100.26.183.102:8181/erpsaas/erpsaas/PRB_10";
    private String USER = "clouderp@psl.com.co";
    private String PASS = "clouderp456";
    
    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Documents\\GitHub\\Ejercicios-Loggro\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 600);
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, wait, URL_BASE, USER, PASS);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
