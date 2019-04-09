package selenide.steps;

import com.codeborne.selenide.Configuration;

import cucumber.api.java.ru.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;


import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class MTCStepsdefs {
    private String keyword;


    @Дано("открыть браузер МТС")
    public void openGoogleSearch() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/surefire-reports";
        System.setProperty("webdriver.chrome.driver", "C:\\project\\cucumber\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://moskva.mts.ru/personal");
    }


    @И("ввести номер телефона (.*)")
    public void ввести_номер_телефона(String tab) {
        $(By.xpath(".//input[@placeholder='Номер телефона']")).sendKeys(tab);

    }

    @И("ввести сумму (.*)")
    public void ввести_сумму(String tab) {
        $(By.xpath(".//input[@placeholder='Сумма']")).setValue(tab);
    }

    @И("нажать кнопку (.*)")
    public void нажать_кнопку(String button) {
        $(By.xpath(".//button[text()='" + button + "']")).click();
        int i = 1;
    }

    @И("проверить сумму (.*)")
    public void проверить_сумму(String tab) {
        assertEquals($(By.xpath(".//input[@data-type='amount']")).getValue().replaceAll("/[^0-9]/", "").substring(0, tab.length()), tab);
    }

    @И("проверить телефон (.*)")
    public void проверить_телефон(String tab) {
        assertEquals($(By.xpath(".//input[@data-type='phone' and @name='Parameters[0].Val1']")).getValue().replaceAll("/[^0-9]/", ""), tab);


    }
}


