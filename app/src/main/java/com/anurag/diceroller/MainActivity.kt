package com.anurag.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Do a dice roll when the app starts
        rollDice()
/*this function finds the button by ID
  and attaches to the function rollDice()*/
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "the DICE rolled successfully!", Toast.LENGTH_LONG)
                .show()
            rollDice()
        }

    }

    /*this a private Function outside the main activity,
    just to store the dice object and use it to perform the on-click diceRoll.
    and attach it to  textView and display the result!;
     */
    private fun rollDice() {
        //create a 6 sided dice object and roll it!
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        //drawable resources swap XD!
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}

/*
*the Class that stores Dice method!
 */
class Dice {
    private val numSides: Int

    constructor(numSides: Int) {
        this.numSides = numSides
    }

    fun roll(): Int {
        return (1..6).random()
    }
}
