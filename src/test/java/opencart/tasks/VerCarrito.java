package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.InicioPage;

public class VerCarrito {

    public static Performable deCompras() {
        return Task.where("Visualiza el carrito de compras",
                Click.on(InicioPage.BOTON_CARRITO),
                Click.on(InicioPage.ENLACE_VER_CARRITO));
    }

    private VerCarrito() {
    }
}