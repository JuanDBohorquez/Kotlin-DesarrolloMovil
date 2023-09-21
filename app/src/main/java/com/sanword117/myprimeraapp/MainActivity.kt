package com.sanword117.myprimeraapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import kotlin.math.cos


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numero1 = findViewById<EditText>(R.id.editTextNumero1)
        val numero2 = findViewById<EditText>(R.id.editTextNumero2)
        val textResultado = findViewById<TextView>(R.id.textViewResultado)
        val botonSumar = findViewById<Button>(R.id.buttonSumar)
        val botonRestar = findViewById<Button>(R.id.buttonResta)
        val botonMulti = findViewById<Button>(R.id.buttonMulti)
        val botonDiv = findViewById<Button>(R.id.buttonDiv)
        val Grado = findViewById<EditText>(R.id.editTextAngulo)
        val botoncalCoseno = findViewById<Button>(R.id.buttonConvertir)

        val botonVolverMenu = findViewById<Button>(R.id.buttonVolver)

        botonSumar.setOnClickListener{
            val recogerNum1 = numero1.text.toString().toDouble()
            val recogerNum2 = numero2.text.toString().toDouble()
            val resultado = recogerNum1 + recogerNum2
            textResultado.text = resultado.toString()
        }
        botonRestar.setOnClickListener {
            val recogeNum1 = numero1.text.toString().toDouble()
            val recogeNum2 = numero2.text.toString().toDouble()
            val resultadoR = recogeNum1 - recogeNum2
            textResultado.text = resultadoR.toString()
        }
        botonMulti.setOnClickListener {
            val recogNum1 = numero1.text.toString().toDouble()
            val recogNum2 = numero2.text.toString().toDouble()
            val resultadoM = recogNum1 * recogNum2
            textResultado.text = resultadoM.toString()
        }
        botonDiv.setOnClickListener {
            val recoNum1 = numero1.text.toString().toDouble()
            val recoNum2 = numero2.text.toString().toDouble()
            val resultadoC = recoNum1 / recoNum2
            textResultado.text = resultadoC.toString()
        }

        botonVolverMenu.setOnClickListener {
            val intento = Intent(this, MainActivityMenu::class.java)
            startActivity(intento)
        }

        botoncalCoseno.setOnClickListener {
            val recogerGrado = Grado.text.toString().toDouble()
            if (Grado != null){
                var radianes = Math.toRadians(recogerGrado)
            }
            val coseno = cos(recogerGrado)
            textResultado.text = coseno.toString()

        }


    }
}