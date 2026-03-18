package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SauceLoginScreen extends PageObject {

    // Menú hamburguesa
    @AndroidFindBy(accessibility = "View menu")
    private WebElement btnMenu;

    // Opción Log In del menú lateral
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log In\")")
    private WebElement btnLogIn;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement txtUsuario;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement txtPassword;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement tituloApp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    private List<WebElement> lista2;

    public void clickMenu() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(btnMenu));
        btnMenu.click();
    }
    public void clickMenuLogIn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogIn));
        btnLogIn.click();
    }

    public void ingresarUsuario(String texto){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(txtUsuario));
        txtUsuario.sendKeys(texto);
    }

    public void esperarElemento(WebElement elemento){
        waitFor(ExpectedConditions.elementToBeClickable(elemento));
    }

    public void ingresarClave(String clave) {
        txtPassword.sendKeys(clave);
    }

    public void ingresar() {
        btnLogin.click();
    }
    public int getCountElements(){
        //List<WebElement> lista = getDriver().findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]"));
        return lista2.size();
    }

//
    public String getTitulo() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(tituloApp));

        //WebElement titulo2 = getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));

        //return titulo2.getText();
        return tituloApp.getText();


    }



}
