package com.sanword117.myprimeraapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Random
import kotlin.math.abs

class MainActivityJuego : AppCompatActivity() {

    private var textoVictoria: TextView? = null
    private lateinit var botones: Array<Int>
    private var tablero = intArrayOf(
        0, 0, 0,
        0, 0, 0,
        0, 0, 0
    )
    private var estado = 0
    private var fichasPuestas = 0
    private var turno = 1
    private var posGanadora = intArrayOf(-1, -1, -1)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_juego)
        textoVictoria = findViewById<View>(R.id.textoVictoria) as TextView
        textoVictoria!!.visibility = View.INVISIBLE
        botones = arrayOf(
            R.id.b1, R.id.b2, R.id.b3,
            R.id.b4, R.id.b5, R.id.b6,
            R.id.b7, R.id.b8, R.id.b9
        )

        val botonVolverMenu = findViewById<Button>(R.id.buttonVolverMenuJJ)

        botonVolverMenu.setOnClickListener {
            val intentoF = Intent(this, MainActivityMenu::class.java)
            startActivity(intentoF)
        }
    }

    fun ponerFicha(view: View) {
        if (estado == 0) {
            turno = 1
            val numBoton = listOf(*botones).indexOf(view.id)
            if (tablero[numBoton] == 0) {
                view.setBackgroundResource(R.drawable.cruz)
                tablero[numBoton] = 1
                fichasPuestas += 1
                estado = comprobarEstado()
                terminarPartida()
                if (estado == 0) {
                    turno = -1
                    ia()
                    fichasPuestas += 1
                    estado = comprobarEstado()
                    terminarPartida()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun terminarPartida() {
        var fichaVictoria = R.drawable.cruzganadora
        if (estado == 1 || estado == -1) {
            if (estado == 1) {
                textoVictoria!!.visibility = View.VISIBLE
                textoVictoria!!.setTextColor(Color.GREEN)
            } else {
                textoVictoria!!.visibility = View.VISIBLE
                textoVictoria!!.text = "Has perdido ;("
                textoVictoria!!.setTextColor(Color.RED)
                fichaVictoria = R.drawable.circuloganador
            }
            for (i in posGanadora.indices) {
                val b = findViewById<Button>(botones[posGanadora[i]])
                b.setBackgroundResource(fichaVictoria)
            }
        } else if (estado == 2) {
            textoVictoria!!.visibility = View.VISIBLE
            textoVictoria!!.text = "Has empatado"
        }
    }

    private fun ia() {
        val ran = Random()
        var pos = ran.nextInt(tablero.size)
        while (tablero[pos] != 0) {
            pos = ran.nextInt(tablero.size)
        }
        val b = findViewById<View>(botones[pos]) as Button
        b.setBackgroundResource(R.drawable.circulo)
        tablero[pos] = -1
    }

    private fun comprobarEstado(): Int {
        var nuevoEstado = 0
        if (abs(tablero[0] + tablero[1] + tablero[2]) == 3) {
            posGanadora = intArrayOf(0, 1, 2)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[3] + tablero[4] + tablero[5]) == 3) {
            posGanadora = intArrayOf(3, 4, 5)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[6] + tablero[7] + tablero[8]) == 3) {
            posGanadora = intArrayOf(6, 7, 8)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[0] + tablero[3] + tablero[6]) == 3) {
            posGanadora = intArrayOf(0, 3, 6)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[1] + tablero[4] + tablero[7]) == 3) {
            posGanadora = intArrayOf(1, 4, 7)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[2] + tablero[5] + tablero[8]) == 3) {
            posGanadora = intArrayOf(2, 5, 8)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[0] + tablero[4] + tablero[8]) == 3) {
            posGanadora = intArrayOf(0, 4, 8)
            nuevoEstado = 1 * turno
        } else if (abs(tablero[2] + tablero[4] + tablero[6]) == 3) {
            posGanadora = intArrayOf(2, 4, 6)
            nuevoEstado = 1 * turno
        } else if (fichasPuestas == 9) {
            nuevoEstado = 2
        }
        return nuevoEstado
    }

}