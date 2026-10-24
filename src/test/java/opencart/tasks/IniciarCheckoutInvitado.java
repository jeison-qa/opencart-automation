package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.CarritoPage;
import opencart.ui.CheckoutPage;

public class IniciarCheckoutInvitado {

    public static Performable desdeElCarrito() {
        return Task.where("Inicia el checkout como invitado (Guest Checkout)",
                Click.on(CarritoPage.BOTON_CHECKOUT),
                Click.on(CheckoutPage.OPCION_INVITADO),
                Click.on(CheckoutPage.BOTON_CONTINUAR_OPCIONES));
    }

    private IniciarCheckoutInvitado() {
    }
}