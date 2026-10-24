package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.InicioPage;

public class AgregarAlCarrito {

    public static Performable elProducto(String nombre) {
        return Task.where("Agrega el producto " + nombre + " al carrito",
                Click.on(InicioPage.botonAgregar(nombre)),
                EsperarProductoAgregado.de(nombre));
    }

    private AgregarAlCarrito() {
    }
}