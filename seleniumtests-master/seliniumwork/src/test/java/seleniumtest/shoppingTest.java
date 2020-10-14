package seleniumtest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shoppingTest {
	
	private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\Users\oejac\Downloads\seliniumwork\seliniumwork\src\test\resources\drivers");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(1500);
        WebElement target = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]"));
        target.sendKeys("black");
        Thread.sleep(1500);      
        WebElement selection = driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]"));
        selection.click();
        Thread.sleep(1500);       
        WebElement found = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/h1"));               
        assertEquals("Printed Summer Dress", found.getText());        
        WebElement addToCart = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();
        WebElement proceed = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        proceed.click();
        Thread.sleep(1500);        
        WebElement total = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tfoot/tr[7]/td[2]/span"));
        Thread.sleep(1500);        
        assertEquals("$30.98", total.getText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
	


