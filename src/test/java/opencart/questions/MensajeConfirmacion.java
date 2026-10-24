package opencart.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MensajeConfirmacion {

    private static final By TITULO = By.cssSelector("#content h1");

    /** Espera el mensaje (llega por AJAX) y devuelve el titulo de la pagina para compararlo. */
    public static Question<String> delPedido(String esperado) {
        return Question.about("el mensaje de confirmacion del pedido")
                .answeredBy(actor -> {
                    WebDriver driver = BrowseTheWeb.as(actor).getDriver();
                    try {
                        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                                ExpectedConditions.textToBePresentInElementLocated(TITULO, esperado));
                    } catch (TimeoutException e) {
                        // se devuelve el texto actual para que la asercion muestre que hay en pantalla
                    }
                    return driver.findElement(TITULO).getText().trim();
                });
    }

    private MensajeConfirmacion() {
    }
}