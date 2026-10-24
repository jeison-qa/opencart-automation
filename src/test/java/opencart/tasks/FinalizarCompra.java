package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.CheckoutPage;

public class FinalizarCompra {

    public static Performable continuandoConElEnvioPorDefecto() {
        return Task.where("Continua con el metodo de envio por defecto",
                Click.on(CheckoutPage.BOTON_CONTINUAR_ENVIO));
    }

    public static Performable aceptandoTerminosYContinuandoConElPago() {
        return Task.where("Acepta los terminos y condiciones y continua con el metodo de pago",
                Click.on(CheckoutPage.CHECK_TERMINOS),
                Click.on(CheckoutPage.BOTON_CONTINUAR_PAGO));
    }

    public static Performable confirmandoElPedido() {
        return Task.where("Confirma el pedido",
                Click.on(CheckoutPage.BOTON_CONFIRMAR_PEDIDO));
    }

    private FinalizarCompra() {
    }
}