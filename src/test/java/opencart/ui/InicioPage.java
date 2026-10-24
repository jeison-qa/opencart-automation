package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioPage {

    /** Boton "Add to Cart" del producto destacado con el nombre indicado. */
    public static Target botonAgregar(String producto) {
        return Target.the("boton Add to Cart de " + producto).located(By.xpath(
                "//div[contains(@class,'product-thumb')][.//h4/a[normalize-space()='" + producto + "']]"
                        + "//button[.//i[contains(@class,'fa-shopping-cart')]]"));
    }

    public static final Target BOTON_CARRITO =
            Target.the("boton del carrito en la cabecera")
                    .located(By.xpath("//div[@id='cart']/button"));

    public static final Target ENLACE_VER_CARRITO =
            Target.the("opcion View Cart del menu del carrito")
                    .located(By.xpath("//div[@id='cart']//a[contains(@href,'checkout/cart')]"));

    private InicioPage() {
    }
}