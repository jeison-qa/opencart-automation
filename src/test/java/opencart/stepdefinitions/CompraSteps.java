package opencart.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import opencart.tasks.AbrirTienda;
import io.cucumber.java.en.When;
import opencart.tasks.AgregarAlCarrito;
import opencart.tasks.VerCarrito;
import io.cucumber.datatable.DataTable;
import opencart.tasks.CompletarDatosFacturacion;
import opencart.tasks.IniciarCheckoutInvitado;
import java.util.Map;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import io.cucumber.java.en.Then;
import opencart.questions.MensajeConfirmacion;
import opencart.tasks.FinalizarCompra;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CompraSteps {

    /** Prepara el escenario de Screenplay: cada actor recibe su propio navegador. */
    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el cliente abre la tienda OpenCart")
    public void elClienteAbreLaTienda() {
        theActorCalled("Cliente").attemptsTo(AbrirTienda.opencart());
    }
    @When("agrega al carrito el producto {string}")
    public void agregaAlCarritoElProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProducto(producto));
    }
    @When("visualiza el carrito de compras")
    public void visualizaElCarrito() {
        theActorInTheSpotlight().attemptsTo(VerCarrito.deCompras());
    }
    @When("inicia el checkout como invitado")
    public void iniciaElCheckoutComoInvitado() {
        theActorInTheSpotlight().attemptsTo(IniciarCheckoutInvitado.desdeElCarrito());
    }

    @When("completa los datos de facturacion con:")
    public void completaLosDatosDeFacturacion(DataTable tabla) {
        Map<String, String> datos = tabla.asMaps().get(0);
        theActorInTheSpotlight().attemptsTo(CompletarDatosFacturacion.con(datos));
    }
    @When("continua con el metodo de envio por defecto")
    public void continuaConElMetodoDeEnvio() {
        theActorInTheSpotlight().attemptsTo(FinalizarCompra.continuandoConElEnvioPorDefecto());
    }

    @When("acepta los terminos y condiciones y continua con el metodo de pago")
    public void aceptaLosTerminos() {
        theActorInTheSpotlight().attemptsTo(
                FinalizarCompra.aceptandoTerminosYContinuandoConElPago());
    }

    @When("confirma el pedido")
    public void confirmaElPedido() {
        theActorInTheSpotlight().attemptsTo(FinalizarCompra.confirmandoElPedido());
    }

    @Then("debe ver el mensaje de confirmacion {string}")
    public void debeVerElMensajeDeConfirmacion(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat(MensajeConfirmacion.delPedido(mensaje), equalTo(mensaje)));
    }
}