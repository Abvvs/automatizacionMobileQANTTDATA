package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsScreen extends PageObject {
    // Título Products - valida carga de app
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement tituloScreenProducts;

    // Lista de titulos de productos
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private List<WebElement> listaTitulosProductos;

    // Carrito
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement btnAgregarProduct;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartBt\")")
    private WebElement btnAgregarCarrito;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement btnCarrito;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement unidadesEnCarrito;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement tituloEnCarrito;



    // Validar que la app cargó
    public boolean appCargada() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(tituloScreenProducts));
        return tituloScreenProducts.getText().equalsIgnoreCase("Products")
                && listaTitulosProductos.size() > 0;
    }

    public void clickProductoPorNombre(String tituloProducto) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        String xpath = "//android.widget.ImageView[@content-desc='" + tituloProducto + "']";

        WebElement producto = wait.until(
                ExpectedConditions.elementToBeClickable(
                        org.openqa.selenium.By.xpath(xpath)
                )
        );

        producto.click();
    }

    public void agregarAlCarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(btnAgregarCarrito));
        btnAgregarCarrito.click();
    }

    public void aumentarUnidades(int cantidad) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(btnAgregarProduct));
        for (int i = 0; i < cantidad; i++) {
            btnAgregarProduct.click();
        }

    }
    public void volverAtras() {
        getDriver().navigate().back();
    }

    public void irAlCarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(btnCarrito)).click();
    }

    public boolean validarProductoEnCarrito(String tituloProducto, int unidades) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        // Esperar que carguen los elementos
        wait.until(ExpectedConditions.visibilityOf(tituloEnCarrito));
        boolean tituloOk = tituloEnCarrito.getText()
                .toLowerCase().contains(tituloProducto.toLowerCase());

        boolean unidadesOk = unidadesEnCarrito.getText()
                .trim().equals(String.valueOf(unidades));

        return tituloOk && unidadesOk;

    }
}
