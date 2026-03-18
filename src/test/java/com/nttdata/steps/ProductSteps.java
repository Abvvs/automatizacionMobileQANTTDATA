package com.nttdata.steps;

import com.nttdata.screens.ProductsScreen;
import org.junit.Assert;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.annotations.Step;

public class ProductSteps extends ScenarioSteps {
    ProductsScreen productsScreen;

    @Step("Validar que la app cargó correctamente")
    public void validarCargaApp() {
        Assert.assertTrue(
                "La app no cargó correctamente o no hay productos",
                productsScreen.appCargada()
        );
    }
    @Step("Agrego {0} unidades del producto {1}")
    public void agregarProducto(int unidades, String tituloProducto) {
        // Buscar y abrir el producto
        productsScreen.clickProductoPorNombre(tituloProducto);

        // Si necesita más unidades, aumentar (unidades - 1) veces
        if (unidades > 1) {
            productsScreen.aumentarUnidades(unidades - 1);
        }

        productsScreen.agregarAlCarrito();
        //volver atras
        productsScreen.volverAtras();
    }

    public void validarCarrito(String tituloProducto, int unidades) {
        productsScreen.irAlCarrito();
        Assert.assertTrue(
                "El carrito no coincide — Producto: '" + tituloProducto
                        + "' Unidades esperadas: " + unidades,
                productsScreen.validarProductoEnCarrito(tituloProducto, unidades)
        );
        productsScreen.volverAtras();
    }
}
