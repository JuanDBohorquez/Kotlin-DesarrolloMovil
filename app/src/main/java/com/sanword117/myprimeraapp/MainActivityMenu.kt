package com.sanword117.myprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val botonAcalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val botonAcajero = findViewById<Button>(R.id.buttonCajero)
        val botonAtriky = findViewById<Button>(R.id.buttonTriky)

        botonAcalculadora.setOnClickListener {

            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)

        }
        
        botonAcajero.setOnClickListener {
            val intento2 = Intent(this, MainActivityCajeroo::class.java)
            startActivity(intento2)
        }

        botonAtriky.setOnClickListener {
            val intento3 = Intent(this, MainActivityJuego::class.java)
            startActivity(intento3)
        }
    }
}