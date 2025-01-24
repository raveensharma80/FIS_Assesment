package TestPack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ebayUITest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void openEbay()
    {

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("gh-ac")).sendKeys("Book");
        driver.findElement(By.id("gh-search-btn")).click();

        //System.out.println(driver.findElement(By.xpath("//div[@id=\"srp-river-results\"]/ul/li[1]")).getText());
       // driver.findElement(By.xpath("//div[@id=\"srp-river-results\"]/ul/li[1]")).click();

        driver.findElement(By.xpath("//div[@id=\"srp-river-results\"]/ul/li[1]/div/div[@class=\"s-item__info clearfix\"]/a[@class=\"s-item__link\"]")).click();

        Set<String> s = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList(s);
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.id("atcBtn_btn_1")).click();

        WebElement cart =  driver.findElement(By.xpath("//div[@class=\"gh-cart\"]/div/a[@class=\"gh-flyout__target\"]/span[@class=\"gh-cart__icon\"]"));

       // System.out.println("Cart has items = "+cart.getText());
        Assert.assertEquals(cart.getText(),"1");
        driver.quit();

    }


}
