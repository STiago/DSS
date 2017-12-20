## Práctica 4. Eclipse BPEL designer y Apache ODE

El objetivo de este documento es desplegar un proyecto BPEL.
Se propone el modelado con BPEL 2.0, utilizando BPEL Designer para Eclipse, de los siguientes procesos de negocio:

#### 4.1. Plan de viaje

Especificar utilizando BPEL el proceso de negocio (cuyo diagrama de actividad se muestra en la siguiente figura) y que se describe informalmente como sigue: “El cliente invoca al proceso de negocio, especificando el nombre del empleado, el destino de su viaje, la fecha de salida, y la fecha de regreso. El proceso de negocio BPEL comprueba primero el status del empleado para viajar (clase turista, business, avión privado); suponemos que existe un servicio Web contra el que se puede realizar esta consulta.

Después, el proceso BPEL comprobará el precio del billete con 2 líneas aéreas: Iberia y Vueling. Supongamos otra vez que ambas compañías proporcionan un servicio Web contra el que se pueden realizar estas gestiones. El proceso BPEL seleccionará el precio más bajo y devolverá un plan de viaje al cliente”.

![Diagram](https://github.com/STiago/DSS/tree/master/practica4/images/enunciado.png)

#### 4.2. Comprador - vendedor

## Enlaces

  - Tutorial BPEL: https://www.eclipse.org/bpel/users/howto/ode.php
