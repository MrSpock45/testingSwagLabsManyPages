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
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;


public class InvenoryPage extends InitSettings {
@Description("Проверить, что на старнице 6 элементов инвентаря")
@Owner("Матвей")
@Test
public void checkCountItem()
{
 LoginPage.seuucesLogin();
 Allure.step("Получаем кол-во, элементов на странице");
 ElementsCollection listIventory = $$(By.className(helperIventoryElemnts.classIventoryName));
 Assertions.assertEquals(listIventory.stream().count(), helperIventoryElemnts.count );
}

@Description("Добавление элемента в крозину.")
 @Owner("Матвей")
 @Test
 public void addItemInBasket()
{
 int countItem=0;//Изначально у нас 0.
 LoginPage.seuucesLogin();
 try {
  Thread.sleep(1000);
 }
 catch (Exception exp){}
 Allure.step("Добавляем товар в корзину");
 $$(By.id(helperIventoryElemnts.idButtonAdd)).get(0).click();
 countItem++;
 try {
  Thread.sleep(1000);
 }  catch (Exception exp){}
 Assertions.assertEquals(String.valueOf(countItem)  ,$(By.className(helperIventoryElemnts.classBasketBadge)).getText());
 Allure.step("У кпноки текст Remove");
 Assertions.assertEquals($$(By.id(helperIventoryElemnts.idButtonRemove)).get(0).getText(),"REMOVE");
}

@Description("Удаление товара из корзины")
@Owner("Матвей")
@Test
public void removeItemInBasket()
{
 addItemInBasket();
 Allure.step("Удаляем товар из корзины");
 $$(By.id(helperIventoryElemnts.idButtonRemove)).get(0).click();
 try {
  Thread.sleep(1000);
 }  catch (Exception exp){}
 Assertions.assertEquals(false, $(By.className(helperIventoryElemnts.classBasketBadge)).isDisplayed());
}

}
