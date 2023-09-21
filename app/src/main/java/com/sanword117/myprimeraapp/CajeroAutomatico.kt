package com.sanword117.myprimeraapp

class CajeroAutomatico {

    private var saldo: Double = 0.0

    fun depositar(cantidad: Double) {
        if (cantidad > 0) {
            saldo += cantidad
        }
    }

    fun retirar(cantidad: Double) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad
        }
    }

    fun consultarSaldo(): Double {
        return saldo
    }
}
