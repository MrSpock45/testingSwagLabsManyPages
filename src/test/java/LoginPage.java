import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.aspectj.lang.reflect.InitializerSignature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends InitSettings {
    @Description("Выполняем успешный вход на сайт")
    @Owner("Матвей")
    @Order(1)
    @Test
    public static void seuucesLogin(){
        Allure.step("Открыть страницу страницу авторизации");
        open("https://www.saucedemo.com/");
        Assertions.assertEquals("https://www.saucedemo.com/", WebDriverRunner.getWebDriver().getCurrentUrl());

        Allure.step("Ввести валидные логин и пароль");
        $(By.id(helperLoginElements.userNameID)).setValue("standard_user");
        $(By.id(helperLoginElements.userPasswordID)).setValue("secret_sauce");

        Allure.step("Нажать на кнопку login");
        $(By.id(helperLoginElements.btnLoginID)).click();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", WebDriverRunner.getWebDriver().getCurrentUrl());
 }

@Description("Нажимаем на кнопку логин, не заполнив поля")
@Owner("Матвей")
@Test public  void loginWithEmptyFields()
{
    Allure.step("Открыть страницу страницу авторизации");
    open("https://www.saucedemo.com/");

    Allure.step("Нажать на кнопку авторизации");
    $(By.id(helperLoginElements.btnLoginID)).click();

    Allure.step("Пользователь остался на стартовой странице");
    Assertions.assertEquals("https://www.saucedemo.com/", WebDriverRunner.getWebDriver().getCurrentUrl());

    Allure.step("Отображатется кнопка с текстом об ошибке");
    Assertions.assertEquals($(By.xpath(helperLoginElements.btnError)).getText(), "Epic sadface: Username is required");
}
@Description("Проверяем закрытие кнопки с текстом ошибки")
@Owner("Матвей")
@Test
public void closeErrorButton()
 {
    loginWithEmptyFields();
    $(By.xpath(helperLoginElements.btnError)).click();
    Allure.step("Кпнока с текстом ошибки не отображается");
    try {
        Thread.sleep(1000);
    }
    catch (Exception exp){}

    Assertions.assertEquals(false , $(By.xpath(helperLoginElements.btnError)).isDisplayed());
 }
}




