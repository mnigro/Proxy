# Proxy
La aplicacion requerida fue desarrollada bajo el lenguaje java y sockets como interfaz que nos permite capturar el trafico HTTP sobre el protocolo TCP/IP y loguearlo en la terminal desde donde fue ejecutada.

Requerimientos:
JRE (Java Runtime Environment) instalado.

Configuracion inicial de prueba (browser Chrome en mac):
1. Click en el menu de Chrome en la barra de herramientas del navegador.
2. Selecione "Configuración". 
3. Click en "Avanzada".
4. En la sección "Sistema", click en "Abrir Configuracion de Proxy".
5. En la pestaña "Proxies" seleccionar el protocolo "Proxy de web (HTTP)" 
6. En "Servidor proxy de web" ingresar la IP 127.0.0.1 el puerto 3567 y click en Ok.
7. Click en "Aplicar" de la ventana "Red".

Ejecucion de la aplicacion Proxy:
1. Abrir una terminal.
2. Tipear el comando: java -jar path del archivo Proxy.jar donde se encuentre alojado. 
ej.: java - jar /Users/mnigro/IdeaProjects/Proxy/out/artifacts/Proxy_jar/Proxy.jar
