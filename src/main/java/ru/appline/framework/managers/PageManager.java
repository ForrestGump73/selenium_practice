package ru.appline.framework.managers;

import ru.appline.framework.pages.ProductsPage;
import ru.appline.framework.pages.HomePage;


/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка товаров
     */
    private ProductsPage productsPage;


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return StartPage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link ProductsPage}
     *
     * @return ProductsPage
     */
    public ProductsPage getProductsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }



}