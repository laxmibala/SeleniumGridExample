import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGrid {

    public static void main(String[] args) {
        String hub_url ="http://10.22.95.16:4445/wd/hub";
        String node_url ="http://10.22.95.16:5555/wd/hub";
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\laxmi_bala\\driver\\chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities =DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        try {
            RemoteWebDriver driver =new RemoteWebDriver(new URL(node_url),capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://www.google.co.in");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
