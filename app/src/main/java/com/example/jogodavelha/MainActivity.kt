package com.example.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var isPlayer1 = true
    var gameEnd = false

    private lateinit var top: ImageView
    private lateinit var topStart: ImageView
    private lateinit var topEnd: ImageView

    private lateinit var center: ImageView
    private lateinit var centerStart: ImageView
    private lateinit var centerEnd: ImageView

    private lateinit var bottom: ImageView
    private lateinit var bottomStart: ImageView
    private lateinit var bottomEnd: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        top = findViewById(R.id.top)
        topStart = findViewById(R.id.top_start)
        topEnd = findViewById(R.id.top_end)

        center = findViewById(R.id.center)
        centerStart = findViewById(R.id.center_start)
        centerEnd = findViewById(R.id.center_end)

        bottom = findViewById(R.id.bottom)
        bottomStart = findViewById(R.id.bottom_start)
        bottomEnd = findViewById(R.id.bottom_end)

        val reset: Button = findViewById(R.id.button_reset)
        reset.setOnClickListener {
            resetBox(top)
            resetBox(topStart)
            resetBox(topEnd)

            resetBox(center)
            resetBox(centerStart)
            resetBox(centerEnd)

            resetBox(bottom)
            resetBox(bottomStart)
            resetBox(bottomEnd)
        }

        configureBox(top)
        configureBox(topStart)
        configureBox(topEnd)

        configureBox(center)
        configureBox(centerStart)
        configureBox(centerEnd)

        configureBox(bottom)
        configureBox(bottomStart)
        configureBox(bottomEnd)
    }

    private fun resetBox(box: ImageView) {
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd = false
    }

    private fun configureBox(box: ImageView) {
        box.setOnClickListener {
            if(box.tag == null && !gameEnd) {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                    isPlayer1 = false
                    box.tag = 1
                } else {
                    box.setImageResource(R.drawable.ic_baseline_close_24)
                    isPlayer1 = true
                    box.tag = 2
                }

                if (playerWin(1)) {
                    Toast.makeText(this@MainActivity, "player 1 Venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                } else if (playerWin(2)) {
                    Toast.makeText(this@MainActivity, "player 2 Venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }
        }
    }

    private fun playerWin(value: Int): Boolean {
        if( (top.tag == value && center.tag == value && bottom.tag == value) ||
            (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value) ||
            (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||

            (topStart.tag == value && top.tag == value && topEnd.tag == value) ||
            (centerStart.tag == value && center.tag == value && centerEnd.tag == value) ||
            (bottomStart.tag == value && bottom.tag == value && bottomEnd.tag == value) ||

            (topStart.tag == value && center.tag == value && bottomEnd.tag == value) ||
            (topEnd.tag == value && center.tag == value && bottomStart.tag == value) ) {
            return true
        }
            return false
    }
}
// Como Criar Um Aplicativo No Android Studio (Super Simples!) | Jogo da Velha
// https://www.youtube.com/watch?v=gTnAnye5F8s

// Como Criar APLICATIVO Android do ZERO (Super Simples!) | Jogo da Velha Parte 2
// https://www.youtube.com/watch?v=1m2q6jq3mWQ