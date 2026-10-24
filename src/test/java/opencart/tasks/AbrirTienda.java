package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirTienda {

    private static final String URL =
            System.getProperty("opencart.base.url", "http://opencart.abstracta.us/");

    public static Performable opencart() {
        return Task.where("Abre la tienda OpenCart", Open.url(URL));
    }

    private AbrirTienda() {
    }
}