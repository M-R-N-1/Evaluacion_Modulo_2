# Evaluación Módulo 2: Fundamentos de Programación en Java

## Objetivo del Proyecto
* El objetivo del proyecto "Alke Wallet" es desarrollar una billetera digital que permita a los usuarios gestionar sus activos financieros de manera segura y conveniente.
* Se busca  entregar una aplicación funcional, segura y fácil de usar que proporcione a los usuarios una solución confiable para administrar sus activos financieros de manera digital.
* Se debe brindar a los usuarios una solución segura y fácil de usar para administrar sus activos financieros de manera digital, permitiendo a los usuarios realizar transacciones dentro de la plataforma.

## Estructura del modelo Alke Wallet

* La estructura funcional del modelo se basa en una clase “Cuenta” sin denominación monetaria en específico, la cual posee los atributos esenciales para la creación de una nueva instancia. Dicha cuenta implementa los métodos que se especifican en la interface “IOperaciones”, que son los procesos los que debe ejecutar cada cuenta. 
* De la superclase “Cuenta” heredan sus atributos y métodos las subclases “CuentaPesoCL” y “CuentaUSD”, sin perjuicio de que se pueden crear nuevas cuentas con diferentes denominaciones monetarias, donde cada una posee su tipo de cambio y conversión a otra denominación monetaria. 
* En la clase “Principal” se ejecutan los procesos, partiendo por la solicitud de los datos y valores que se requieren para la creación de una cuenta y posterior realización de las transacciones, posteriormente a crear una cuenta se muestra un menú de opciones para que el usuario pueda simular una interacción como en un banco se tratase, pudiendo solicitar información, realizar transacciones y conversiones monetarias cuantas veces sea necesario siempre que se cumplan con los requerimientos y validaciones especificadas en cada uno de los atributos y métodos de las clases. 
* Para finalizar el proyecto, se desarrollaron pruebas unitarias con JUnit Test Case para cada uno de los métodos de las clases, simulando transacciones que se deben ejecutar y eventualmente puedan generar errores lógicos y de implementación, asegurando así la correcta ejecución de la aplicación gracias a la captación de situaciones que deben ser subsanadas antes de ejecutar el programa.

## Representación UML del proyecto
<div align="center"><img width="800" height="800" alt="Captura de pantalla 2026-01-31 200204" src="https://github.com/user-attachments/assets/f31fd5fb-fc69-4c32-9040-2142262338d7" /></div>
