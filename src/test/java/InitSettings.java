import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class InitSettings {

    @BeforeAll
    static void setUp()
    {
       /* ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        options.addExtensions(new File("resources\\CryptoPro.crx"));
        options.addExtensions(new File("resources\\Blitz.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;*/

        // addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
     //  capabilities.setVersion("C:\\Users\\lubom\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
       // options.addExtensions(new File("resources\\Blitz.crx"));
       // options.addExtensions(new File("resources\\CryptoPro.crx"));
        // options.addExtensions(new File("resources\\CryptoProOld.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;

    }
}