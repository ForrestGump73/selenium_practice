package ru.appline.framework.tests;

import org.junit.jupiter.api.Test;
import ru.appline.framework.basetestsclass.BaseTests;
import ru.appline.framework.pages.ProductsPage;

public class PracticeTests extends BaseTests {


    @Test
    public void startVegTest() {
        app.getHomePage()
                .selectBaseMenu()
                .selectProducts()
                .checkOpenProductsPage()
                .selectButtonEdit()
                .checkOpenAddProduct()
                .fillFieldName("Картошка")
                .selectTypeOfProduct("Овощ")
                .checkboxExoticOff()
                .saveProduct();


        try {
            Thread.sleep(30000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void startFruitTest() {
        app.getHomePage()
                .selectBaseMenu()
                .selectProducts()
                .checkOpenProductsPage()
                .selectButtonEdit()
                .checkOpenAddProduct()
                .fillFieldName("Манго")
                .selectTypeOfProduct("Фрукт")
                .checkboxExoticOn()
                .saveProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
