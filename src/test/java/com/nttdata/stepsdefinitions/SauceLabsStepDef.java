package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SuaceLabsLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SauceLabsStepDef {
    @Steps
    SuaceLabsLoginSteps login;

    @Given("ingreso al aplicativo de SauceLabs")
    public void ingresoAlAplicativoDeSauceLabs() {
        login.ingresoAlAplicativo(); // navega al login via menú
    }

    @When("ingreso el usuario {string}")
    public void ingresoElUsuario(String usuario) {
        login.ingresoElUsuario(usuario);
    }

    @When("inicio sesión con mi usuario {string} y clave {string}")
    public void inicioSesiónConMiUsuarioYClave(String usuario, String clave) {
        login.ingresoElUsuario(usuario);
        login.ingresarClave(clave);
        login.ingresar();
    }

    @And("ingreso la clave {string}")
    public void ingresoLaClave(String clave) {
        login.ingresarClave(clave);
    }

    @And("hago clic en LOGIN")
    public void hagoClicEn() {
        login.ingresar();
    }

    @Then("valido el login OK")
    public void validoElLoginOK() {
        login.validacionLogin();
    }
}
