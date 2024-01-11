package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@id = 'navbarDropdown']")
    private WebElement dropMenu;

    @FindBy(xpath = "//a[text() = 'Товары']")
    private WebElement products;

    public HomePage selectBaseMenu(){
        waitUtilElementToBeClickable(dropMenu);
        dropMenu.click();
        return this;
    }

    public ProductsPage selectProducts(){
        waitUtilElementToBeClickable(products);
        products.click();
        return pageManager.getProductsPage();
    }





}
