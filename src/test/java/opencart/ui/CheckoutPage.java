package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    // Paso 1: Checkout Options
    public static final Target OPCION_INVITADO =
            Target.the("opcion Guest Checkout")
                    .located(By.cssSelector("input[name='account'][value='guest']"));
    public static final Target BOTON_CONTINUAR_OPCIONES =
            Target.the("boton Continue de Checkout Options").located(By.id("button-account"));

    // Paso 2: Billing Details
    public static final Target NOMBRE =
            Target.the("campo First Name").located(By.id("input-payment-firstname"));
    public static final Target APELLIDO =
            Target.the("campo Last Name").located(By.id("input-payment-lastname"));
    public static final Target CORREO =
            Target.the("campo E-Mail").located(By.id("input-payment-email"));
    public static final Target TELEFONO =
            Target.the("campo Telephone").located(By.id("input-payment-telephone"));
    public static final Target DIRECCION =
            Target.the("campo Address 1").located(By.id("input-payment-address-1"));
    public static final Target CIUDAD =
            Target.the("campo City").located(By.id("input-payment-city"));
    public static final Target CODIGO_POSTAL =
            Target.the("campo Post Code").located(By.id("input-payment-postcode"));
    public static final Target PAIS =
            Target.the("lista Country").located(By.id("input-payment-country"));
    public static final Target REGION =
            Target.the("lista Region / State").located(By.id("input-payment-zone"));
    public static final Target BOTON_CONTINUAR_FACTURACION =
            Target.the("boton Continue de Billing Details").located(By.id("button-guest"));
    // Paso 4: Delivery Method
    public static final Target BOTON_CONTINUAR_ENVIO =
            Target.the("boton Continue de Delivery Method").located(By.id("button-shipping-method"));
    // Paso 5: Payment Method
    public static final Target CHECK_TERMINOS =
            Target.the("casilla de terminos y condiciones")
                    .located(By.cssSelector("input[name='agree']"));
    public static final Target BOTON_CONTINUAR_PAGO =
            Target.the("boton Continue de Payment Method").located(By.id("button-payment-method"));
    // Paso 6: Confirm Order
    public static final Target BOTON_CONFIRMAR_PEDIDO =
            Target.the("boton Confirm Order").located(By.id("button-confirm"));

    private CheckoutPage() {
    }
}