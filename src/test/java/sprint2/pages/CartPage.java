package sprint2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sprint2.utils.ClaseBase;
import java.util.List;

public class CartPage extends ClaseBase {
    // Centralizar los localizador


    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verificarProductosAgregados(String product1, String product2){
        By locatorTxtItem1 = By.xpath("//td[contains(text(),'"+ product1 +"')]");
        By locatorTxtItem2 = By.xpath("//td[contains(text(),'"+ product2 +"')]");
        String textoProducto1 = obtenerTexto(locatorTxtItem1);
        String textoProducto2 = obtenerTexto(locatorTxtItem2);
        if (!textoProducto1.isEmpty() && !textoProducto2.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public void eliminarProductos(){
        WebElement tabla = getDriver().findElement(By.id("tbodyid"));
        List<WebElement> filas = tabla.findElements(By.tagName("tr"));
        // Ahora tengo la lista de filas y puedo realizar operaciones en ellas

        int i = 0;
        while (i < filas.size()) {
            i++; // Aumentar i para avanzar a la siguiente fila
            WebElement fila = filas.get(i);
            // Realiza operaciones en cada fila

            By locatorLinkDelete = By.xpath("//tbody/tr["+ i +"]/td[4]/a[1]");
            click(esperarPorPresenciaDeElementoClickeable(locatorLinkDelete));
        }
    }
}
