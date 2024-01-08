package org.ibs;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestPractice {
    static int countTests = 1;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Запуск тестов...");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Запуск теста № " + countTests);
    }



    @Test
    void testVegetable() {
        System.setProperty("webdriver.chromedriver.driver","\\src\\test\\resources\\chromedriver.exe");


        ChromeOptions co = new ChromeOptions();
        co.setBinary("\"C:\\TestChrome\\chrome-win64\\chrome.exe\"");
        WebDriver driver = new ChromeDriver(co);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("http://localhost:8080/food");


//          Нажать кнопку "Добавить"


        WebElement btnEdit = driver.findElement(By.xpath("//button[contains(text(), 'Добавить')]"));
        btnEdit.click();


//          Заполнить поле наименование значением: "Картошка"

        driver.findElement(By.id("name")).sendKeys("Картошка");


//        Из селекта Тип выбрать значение "Овощ"

        Select dropdown = new Select(driver.findElement(By.id("type")));
        dropdown.selectByValue("VEGETABLE");


//        Чекбокс Экзотический оставить выключенным

        if ( driver.findElement(By.id("exotic")).isSelected() )
        {
            driver.findElement(By.id("exotic")).click();
        }


//        Нажать кнопку "Сохранить"

        WebElement btnSave = driver.findElement(By.id("save"));
        btnSave.click();


//        Ожидание загрузки страницы

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));



//        Проверить значения добавленных полей:
//        Наименование -"Картошка"
//        Тип - "Овощ"
//        Экзотический - "false"

        WebElement nameElement = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        Assertions.assertEquals("Картошка", nameElement.getText());

        WebElement typeElement = driver.findElement(By.xpath("//tbody/tr[last()]/td[2]"));
        Assertions.assertEquals("Овощ", typeElement.getText());

        WebElement exoticElement = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]"));
        Assertions.assertEquals("false", exoticElement.getText());





        driver.quit();
    }


    @Test
    void testFruit() {
        System.setProperty("webdriver.chromedriver.driver","\\src\\test\\resources\\chromedriver.exe");


        ChromeOptions co = new ChromeOptions();
        co.setBinary("\"C:\\TestChrome\\chrome-win64\\chrome.exe\"");
        WebDriver driver = new ChromeDriver(co);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("http://localhost:8080/food");


//          Нажать кнопку "Добавить"

        WebElement btnEdit = driver.findElement(By.xpath("//button[contains(text(), 'Добавить')]"));
        btnEdit.click();


//          Заполнить поле наименование значением: "Манго"

        driver.findElement(By.id("name")).sendKeys("Манго");


//        Из селекта Тип выбрать значение "Фрукт"

        Select dropdown = new Select(driver.findElement(By.id("type")));
        dropdown.selectByValue("FRUIT");


//        Включить чекбокс Экзотический

        if ( !driver.findElement(By.id("exotic")).isSelected() )
        {
            driver.findElement(By.id("exotic")).click();
        }


//        Нажать кнопку "Сохранить"

        WebElement btnSave = driver.findElement(By.id("save"));
        btnSave.click();


//        Ожидание загрузки страницы

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tbody")));


//        Проверить значения добавленных полей:
//        Наименование -"Манго"
//        Тип - "Фрукт"
//        Экзотический - "true"

        WebElement nameElement = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        Assertions.assertEquals("Манго", nameElement.getText());

        WebElement typeElement = driver.findElement(By.xpath("//tbody/tr[last()]/td[2]"));
        Assertions.assertEquals("Фрукт", typeElement.getText());

        WebElement exoticElement = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]"));
        Assertions.assertEquals("true", exoticElement.getText());





        driver.quit();
    }

    @AfterEach
    void afterEach(){
        System.out.println("Тест № " + countTests + " закончен");
        countTests++;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Все тесты закончены");
    }



}


