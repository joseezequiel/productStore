plugins {
    id("java")
}

group = "com.productStore"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Dependencia para Selenium WebDriver para automatización de pruebas
    implementation("org.seleniumhq.selenium:selenium-java:4.16.1")

    // Dependencias para el manejo de documentos Excel con Apache POI
    implementation("org.apache.poi:poi:4.1.2")
    implementation("org.apache.poi:poi-ooxml:4.1.2")

    // Dependencias para el framework de prueba BDD Cucumber
    implementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit:7.14.0")

    // Dependencia para la gestión automática de drivers de Selenium
    implementation("io.github.bonigarcia:webdrivermanager:5.6.2")

    // Dependencia para la generación de informes con Extent Reports y Cucumber 7
    implementation("tech.grasshopper:extentreports-cucumber7-adapter:1.7.0")
}

tasks.test {
    useJUnitPlatform()
}