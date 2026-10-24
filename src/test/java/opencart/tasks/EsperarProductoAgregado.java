package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** Espera la alerta "Success: You have added <producto> to your shopping cart!" (llega por AJAX). */
public class EsperarProductoAgregado implements Interaction {

    private final String producto;

    private EsperarProductoAgregado(String producto) {
        this.producto = producto;
    }

    public static Performable de(String producto) {
        return new EsperarProductoAgregado(producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//div[contains(@class,'alert-success')][contains(.,'" + producto + "')]")));
    }
}