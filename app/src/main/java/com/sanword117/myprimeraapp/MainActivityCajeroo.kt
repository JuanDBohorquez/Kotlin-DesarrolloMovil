package com.sanword117.myprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivityCajeroo : AppCompatActivity() {
    private val cajero = CajeroAutomatico()
    private lateinit var montoEditText: EditText
    private lateinit var saldoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cajeroo )

        val botonDeposito = findViewById<Button>(R.id.buttonDepositar)
        val botonRetiro = findViewById<Button>(R.id.buttonRetirar)
        montoEditText = findViewById(R.id.editTextMonto)
        saldoTextView = findViewById(R.id.textViewSaldo)

        botonDeposito.setOnClickListener {
            realizarOperacion(true)
        }

        botonRetiro.setOnClickListener {
            realizarOperacion(false)
        }
    }

    private fun realizarOperacion(esDeposito: Boolean) {
        val montoStr = montoEditText.text.toString()
        if (montoStr.isNotEmpty()) {
            val monto = montoStr.toDoubleOrNull()
            if (monto != null && monto > 0) {
                if (esDeposito) {
                    cajero.depositar(monto)
                } else {
                    cajero.retirar(monto)
                }
                actualizarSaldo()
                montoEditText.text.clear()
            } else {
                // Manejar caso de monto no válido
                mostrarMensajeError("Monto inválido")
            }
        } else {
            // Manejar caso de entrada vacía
            mostrarMensajeError("Ingrese un monto")
        }
    }

    private fun actualizarSaldo() {
        saldoTextView.text = String.format("Saldo actual: %.2f", cajero.consultarSaldo())
    }

    private fun mostrarMensajeError(mensaje: String) {
        // Puedes mostrar un mensaje de error al usuario
        // por ejemplo, usando un Toast o un AlertDialog.
        // Aquí, simplemente lo mostramos en el TextView de saldo.
        saldoTextView.text = mensaje


        val regresar = findViewById<Button>(R.id.buttonRegresar)

        regresar.setOnClickListener {
            val intento = Intent(this, MainActivityMenu::class.java)
            startActivity(intento)
        }


    }

}