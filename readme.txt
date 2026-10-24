=====================================================================
EJERCICIO 1 - PRUEBA E2E: FLUJO DE COMPRA EN OPENCART (GUEST CHECKOUT)
Proyecto: opencart-automation
Sitio bajo prueba: http://opencart.abstracta.us/
Stack: Serenity BDD (Screenplay) + Cucumber (Gherkin) + Selenium WebDriver
       + Java 17 + Gradle + JUnit 5
=====================================================================

1. QUE HACE LA PRUEBA
---------------------
Automatiza de punta a punta el siguiente flujo:
  1) Abre la tienda OpenCart.
  2) Agrega dos productos al carrito: "MacBook" y "iPhone".
  3) Visualiza el carrito (boton del carrito de la cabecera > View Cart).
  4) Inicia el checkout como invitado ("Guest Checkout") y completa los
     datos de facturacion de prueba.
  5) Continua con el metodo de envio por defecto, acepta terminos y
     condiciones, continua con el metodo de pago y confirma el pedido.
  6) Valida el mensaje final: "Your order has been placed!".

El escenario esta en:
  src/test/resources/features/compra_completa.feature
Los datos de la prueba (productos y datos de facturacion) estan en la tabla
"Examples" de ese mismo archivo.

2. REQUISITOS PREVIOS
---------------------
  - JDK 17 o superior.  Verificar con:  java -version
  - Google Chrome (version reciente). El driver se descarga solo
    (Selenium Manager); no hay que instalar chromedriver.
  - Git.
  - Acceso a Internet (dependencias de Gradle y el sitio de prueba).
  - NO hace falta instalar Gradle: el proyecto incluye Gradle Wrapper
    (gradlew / gradlew.bat).

3. EJECUCION PASO A PASO
------------------------
  Paso 1. Clonar el repositorio:
            git clone <URL_DEL_REPOSITORIO>
            cd opencart-automation

  Paso 2. Verificar que el sitio responde abriendo en el navegador:
            http://opencart.abstracta.us/
          (es un sitio demo publico; si no carga, esperar unos minutos y reintentar).

  Paso 3. Ejecutar la prueba:
          Windows (PowerShell o CMD):
            .\gradlew.bat clean test
          Linux / macOS:
            chmod +x gradlew
            ./gradlew clean test

          Si ya tienes Gradle 9.x instalado, tambien funciona:
            gradle clean test

          Se abre Chrome y se ve ejecutar el flujo completo. Al terminar,
          la consola muestra "BUILD SUCCESSFUL" si el escenario paso.
          Para ejecutar sin ventana (modo headless):
            ./gradlew clean test -Dheadless.mode=true

  Paso 4. Ver el reporte de Serenity (se genera automaticamente al
          terminar, incluso si la prueba falla):
            target/site/serenity/index.html
          Abrirlo con cualquier navegador. Muestra cada paso del flujo con
          capturas de pantalla.

  Paso 5. (Evidencia) El reporte de la ultima ejecucion esta incluido en:
            evidencias/reporte-serenity/index.html
          Para guardar uno nuevo, copiar  target/site/serenity  a
          evidencias/reporte-serenity. La carpeta "target/" esta en
          .gitignore porque se regenera en cada ejecucion; la carpeta
          "evidencias/" si se versiona.

4. PARAMETROS OPCIONALES
------------------------
  -Dheadless.mode=true                    Ejecuta Chrome sin interfaz.
  -Dopencart.base.url=https://otro-host/  Cambia la URL base de la tienda.
  -Dcucumber.filter.tags="@e2e"           Ejecuta solo los escenarios con esa etiqueta.
  -Dwebdriver.wait.for.timeout=20000      Aumenta la espera por elemento (ms).
  Ejemplo:
            ./gradlew clean test -Dheadless.mode=true


5. EJECUCIÓN AUTOMÁTICA CON GITHUB ACTIONS Y GITHUB PAGES
---------------------------------------------------------
El proyecto utiliza GitHub Actions para ejecutar automáticamente las
pruebas E2E y generar el reporte de Serenity.

El flujo de trabajo se encuentra en:
  .github/workflows/e2e.yml

El proceso realiza las siguientes actividades:
  1) Descarga el código del repositorio.
  2) Configura Java 17 y el entorno de Gradle.
  3) Ejecuta las pruebas automatizadas en modo headless.
  4) Genera el reporte de Serenity.
  5) Guarda el reporte como artefacto de la ejecución.
  6) Publica el reporte en GitHub Pages cuando el flujo se ejecuta
     mediante un push a la rama main.

Para consultar la ejecución:
  1) Ingresar al repositorio en GitHub.
  2) Abrir la pestaña Actions.
  3) Seleccionar la ejecución correspondiente.
  4) Revisar el resultado de las pruebas y los pasos del flujo.

Reporte publicado:
  https://jeison-qa.github.io/opencart-automation/

El reporte permite consultar los resultados de las pruebas automatizadas.
Su disponibilidad depende de que GitHub Actions genere los archivos
correctamente y de que GitHub Pages esté configurado.


6. ESTRUCTURA DEL PROYECTO
--------------------------
  build.gradle, settings.gradle, gradlew, gradlew.bat, gradle/   Build y wrapper
  serenity.properties                                            Opciones de Serenity
  src/test/java/opencart/ui/                                     Localizadores (Targets) y runner
  src/test/java/opencart/tasks/                                  Tareas del actor (Screenplay)
  src/test/java/opencart/questions/                              Validaciones
  src/test/java/opencart/stepdefinitions/                        Definicion de pasos Gherkin
  src/test/resources/features/compra_completa.feature            Escenario del flujo de compra
  src/test/resources/serenity.conf                               Configuracion de Chrome
  src/test/resources/junit-platform.properties                   Plugin de reporte y glue de Cucumber
  src/test/resources/logback-test.xml                            Configuracion de logs
  .github/workflows/e2e.yml                                      Ejecucion automatica en GitHub Actions
  evidencias/                                                    Reporte y capturas de ejecuciones
  readme.txt                                                     Este archivo
  conclusiones.txt                                               Hallazgos y conclusiones