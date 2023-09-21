package com.sanword117.myprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivityInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_inicio)

        val usuario = findViewById<EditText>(R.id.editTextUsuario)
        val clave = findViewById<EditText>(R.id.editTextClave)
        val botonIniciar = findViewById<Button>(R.id.buttonIniciar)

        botonIniciar.setOnClickListener {
            if (usuario.text.toString().equals("Admin") && clave.text.toString().equals("12345")){
                val intento = Intent(this, MainActivityMenu::class.java)
                startActivity(intento)
                Toast.makeText(this, "¡Bienvenido ${usuario.text.toString()}!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "¡Datos Incorrectos!", Toast.LENGTH_LONG).show()
            }
        }
    }
}