// SistemaBancarioLegacy.cpp - Codigo a auditar por los estudiantes
#include <iostream>
#include <fstream>
#include <string>

struct CuentaLegacy {
    char* titular; // PUNTERO: apunta a un bloque de memoria reservado con new char[50]
    double saldo;
    int tipoCuenta; // 1: Ahorros, 2: Corriente
    double limiteSobregiro;
};

CuentaLegacy* crearCuenta(const char* nombre, double saldoInicial, int tipo) {
    // PUNTERO: 'c' apunta a una estructura CuentaLegacy creada dinamicamente con new
    CuentaLegacy* c = new CuentaLegacy();

    // PUNTERO: 'titular' tambien apunta a memoria reservada
    // Esta memoria es independiente de la memoria de la estructura 'c'
    c->titular = new char[50];

    strcpy(c->titular, nombre);
    c->saldo = saldoInicial;
    c->tipoCuenta = tipo; 
    c->limiteSobregiro = (tipo == 2) ? 500.0 : 0.0;

    return c;
}

void procesarRetiro(CuentaLegacy* c, double monto) {
    // PUNTERO: 'c' recibe la direccion de una CuentaLegacy existent
    // No se debe hacer delete aqui porque esta funcion no necesariamente es la responsable de destruir la cuenta

    if (c->tipoCuenta == 1 && c->saldo >= monto) {
        c->saldo -= monto;
    } else if (c->tipoCuenta == 2 && (c->saldo + c->limiteSobregiro) >= monto) {
        c->saldo -= monto; // Fuga potencial de logica y sin registro de auditoria
    }

    // PUNTERO: 'c' no se libera en esta funcion.
}

// PUNTEROS Y LIBERACION DE MEMORIA:
// 'c' fue creado con CuentaLegacy* c = new CuentaLegacy(;
// Por lo tanto, al finalizar su uso debe liberarse con delete c;
//
// Pero antes de eliminar la estructura 'CuentaLegacy', se debe liberar la memoria a la que apunta 'titular', porque fue creada con:
// c->titular = new char[50]
// Como 'titular' es un arreglo dinamico, debe liberarse con delete[] c->titular;
//
// El orden correcto es:
//     delete[] c->titular;  // Primero se libera la memoria del puntero titular
//     delete c;             // Despues se libera la estructura CuentaLegacy
//
// Es importante liberar primero 'titular' porque, una vez ejecutado
// 'delete c', ya no se debe acceder a la estructura ni a su puntero
// 'titular'. Si se elimina primero 'c', se pierde el acceso al bloque
// de memoria reservado para 'titular', provocando una fuga de memoria.
