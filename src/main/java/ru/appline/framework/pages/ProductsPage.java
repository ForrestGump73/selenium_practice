package ru.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//a[@id = 'navbarDropdown']")
    private WebElement dropMenu;

    @FindBy(xpath = "//a[text() = 'Товары']")
    private WebElement products;

    @FindBy(xpath = "//h5[text() = 'Список товаров']")
    private WebElement title;


    @FindBy(xpath = "//button[text() = 'Добавить']")
    private WebElement btnEdit;

    @FindBy(xpath = "//div[@class = 'modal fade show']")
    private WebElement editModal;

    @FindBy(id = "name")
    private WebElement fieldName;

    @FindBy(id = "type")
    private WebElement selectType;

    @FindBy(xpath = "//option[@value = \"VEGETABLE\"]")
    private WebElement vegType;

    @FindBy(xpath = "//option[@value = \"FRUIT\"]")
    private WebElement fruitType;

    @FindBy(id = "exotic")
    private WebElement checkboxExotic;

    @FindBy(id = "save")
    private WebElement btnSave;

    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    private WebElement lastProductName;

    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement lastProductType;

    @FindBy(xpath = "//tbody/tr[last()]/td[3]")
    private WebElement lastProductExotic;


    public ProductsPage selectBaseMenu(){
        waitUtilElementToBeClickable(dropMenu);
        dropMenu.click();
        return this;
    }

    public ProductsPage checkOpenProductsPage() {
        Assertions.assertEquals("Список товаров", title.getText());
        return this;
    }

    public ProductsPage selectButtonEdit() {
        scrollToElementJs(btnEdit);
        waitUtilElementToBeClickable(btnEdit).click();
        return this;
    }

    public ProductsPage checkOpenAddProduct() {
        Assertions.assertEquals("modal fade show", editModal.getAttribute("class"));
        return this;
    }

    public ProductsPage fillFieldName(String value) {
        scrollToElementJs(fieldName);
        waitUtilElementToBeClickable(fieldName).click();
        fieldName.sendKeys(value);
        return this;
    }

    public ProductsPage selectTypeOfProduct(String value) {
        scrollToElementJs(selectType);
        waitUtilElementToBeClickable(selectType).click();
        switch (value) {
            case "Овощ":
                vegType.click();
                break;
            case "Фрукт":
                fruitType.click();
                break;
            default:
                Assertions.fail("Тип " + value + " отсуствует в перечне типов");
        }
        return this;
    }

    public ProductsPage checkboxExoticOn() {
        if (!checkboxExotic.isSelected()) {
            checkboxExotic.click();
        }
        return this;

    }

    public ProductsPage checkboxExoticOff() {
        if (checkboxExotic.isSelected()) {
            checkboxExotic.click();
        }
        return this;

    }

    public ProductsPage saveProduct() {
        scrollToElementJs(btnSave);
        waitUtilElementToBeClickable(btnSave).click();
        return this;
    }

}
