package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

    public static final Target BOTON_CHECKOUT =
            Target.the("boton Checkout del carrito")
                    .located(By.xpath("//a[@class='btn btn-primary']"));

    private CarritoPage() {
    }
}
