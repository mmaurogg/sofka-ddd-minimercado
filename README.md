# sofka-ddd-minimercado
Repositorio para realizar la entrega del reto DDD para sofka

# Proyecto

El modelo del trabajo lo pueden consultar en este link: https://drive.google.com/file/d/1UMYimekha19b_svQKcho8alJOshNvUtv/view?usp=sharing
Tenga en cuenta que está montado en Diagrams.net

El proyecto simula un minimercado específicamente en el área de ventas que contiene:

## Proceso
1. Los productos y los clientes deben ser creadas primero de fomra individual.
2. La factura se puede crear con estos dos elementos mas otros que esta pueda necesitar.
3. cada producto es añadido o retirado de la cuenta de la factura que se encuentra en la entidad venta (sale).
4. cuando todos los productos se encuentran en la factura se puede calcular su valor el cual es un evento y se encuentra en su test del pago creado.

## Raices Agregadas
* Cliente (client).
* Factura (invoice).
* Producto (product).

# Test
Los test de eventos se realizaron sobre el envio de dos correos:
 * Cuando el cliente es creado.
 * cuando el cliente paga la factura.

Otros test:
* creacion u actualizacion de componentes de las Raices Agregadas

