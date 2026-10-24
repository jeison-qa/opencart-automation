package opencart.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import opencart.ui.CheckoutPage;

import java.util.Map;

public class CompletarDatosFacturacion {

    public static Performable con(Map<String, String> datos) {
        return Task.where("Completa los datos de facturacion como invitado",
                Enter.theValue(datos.get("nombre")).into(CheckoutPage.NOMBRE),
                Enter.theValue(datos.get("apellido")).into(CheckoutPage.APELLIDO),
                Enter.theValue(datos.get("correo")).into(CheckoutPage.CORREO),
                Enter.theValue(datos.get("telefono")).into(CheckoutPage.TELEFONO),
                Enter.theValue(datos.get("direccion")).into(CheckoutPage.DIRECCION),
                Enter.theValue(datos.get("ciudad")).into(CheckoutPage.CIUDAD),
                Enter.theValue(datos.get("codigo_postal")).into(CheckoutPage.CODIGO_POSTAL),
                SelectFromOptions.byVisibleText(datos.get("pais")).from(CheckoutPage.PAIS),
                SelectFromOptions.byVisibleText(datos.get("region")).from(CheckoutPage.REGION),
                Click.on(CheckoutPage.BOTON_CONTINUAR_FACTURACION));
    }

    private CompletarDatosFacturacion() {
    }
}