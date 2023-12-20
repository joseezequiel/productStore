package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ClaseBase;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class CartPage extends ClaseBase {
    // Centralizar los localizador
    @FindBy(id = "tbodyid")
    WebElement localizadorTabla;

    @FindBy(xpath = "//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    WebElement btnHome;


    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verificarProductosAgregados(String product1, String product2) throws Exception {
        //sleep para que le dé tiempo a que cargue toda la tabla y pueda contar bien las filas.
        sleep(2000);

        By tabla = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr");
        List<WebElement> filas = findElements(tabla);

        int contadorProducto1 = 0;
        int contadorProducto2 = 0;

        for (WebElement fila : filas) {
            // Obtener el texto de la segunda columna de cada fila de la tabla
            String textoProducto = fila.findElement(By.xpath(".//td[2]")).getText();
            if (textoProducto.contains(product1)) {
                contadorProducto1++;
            }
            if (textoProducto.contains(product2)) {
                contadorProducto2++;
            }
        }
        // Verificar que ambos productos estén presentes exactamente una vez
        return contadorProducto1 == 1 && contadorProducto2 == 1;
    }

    // Método para encontrar elementos
    private List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    public boolean tieneElementosLaTabla(WebElement tabla){
        List<WebElement> filas = getDriver().findElements(By.xpath(".//tr"));

        //mayor a 1 porque la primera fila es la cabecera de la tabla
        if(filas.size()>1) {
            // Se encontraron elementos tr dentro del tbody
            return false;
        } else {
            //No hay elementos tr dentro del tbody
            return true;
        }
    }

    public void limpiarCarrito() throws Exception {
        sleep(2000);
        // Verificar si la tabla tiene elementos
        boolean tablaEstaVacia = tieneElementosLaTabla(localizadorTabla);
        if (tablaEstaVacia == false) {
            By listaFilas = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr");
            List<WebElement> filas = findElements(listaFilas);
            System.out.println("cantidad de filas: " + filas.size());

            for (int i = filas.size(); i > 0; i--) {
                // Obtener el botón "Delete" en la fila actual
                WebElement botonDelete = getDriver().findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']/tbody/tr/td[4]/a)[" + (i) + "]"));

                // Hacer clic en el botón "Delete"
                botonDelete.click();
            }
        }
        System.out.println("Se ha limpiado el carrito correctamente.");
    }


    public void eliminarProductos() throws Exception {
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

    public void irAHomeDesdeCarrito() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnHome));
    }
}
