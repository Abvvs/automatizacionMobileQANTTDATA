package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductSteps;
import io.cucumber.java.After;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SauceLabsAppStepsDef {
    @Steps
    ProductSteps product;
    private String productoActual;
    private int unidadesActual;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        // Appium lanza la app automáticamente
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        product.validarCargaApp();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int Unidades, String TituloProducto) {
        this.productoActual = TituloProducto;
        this.unidadesActual = Unidades;
        product.agregarProducto(Unidades, TituloProducto);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        product.validarCarrito(productoActual, unidadesActual);
    }
    @After
    public void tearDown() {
        product.getDriver().quit();
    }
}
