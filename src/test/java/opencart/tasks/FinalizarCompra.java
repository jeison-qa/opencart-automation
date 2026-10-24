package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import opencart.ui.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FinalizarCompra {

    public static Performable continuandoConElEnvioPorDefecto() {
        return Task.where(
                "Continua con el metodo de envio por defecto",
                WaitUntil.the(CheckoutPage.BOTON_CONTINUAR_ENVIO,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BOTON_CONTINUAR_ENVIO)
        );
    }

    public static Performable aceptandoTerminosYContinuandoConElPago() {
        return Task.where(
                "Acepta los terminos y condiciones y continua con el metodo de pago",
                WaitUntil.the(CheckoutPage.CHECK_TERMINOS,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.CHECK_TERMINOS),
                WaitUntil.the(CheckoutPage.BOTON_CONTINUAR_PAGO,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BOTON_CONTINUAR_PAGO)
        );
    }

    public static Performable confirmandoElPedido() {
        return Task.where("Confirma el pedido", WaitUntil.the(CheckoutPage.BOTON_CONFIRMAR_PEDIDO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.BOTON_CONFIRMAR_PEDIDO)
        );
    }
}
