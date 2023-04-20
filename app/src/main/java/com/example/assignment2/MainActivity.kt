package com.example.assignment2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hexBtn: Button = findViewById(R.id.btnHex)
        val rgbBtn: Button = findViewById(R.id.btnRGB)
        val hexValue: EditText = findViewById(R.id.hex)
        val redValue: EditText = findViewById(R.id.red)
        val greenValue: EditText = findViewById(R.id.green)
        val blueValue: EditText = findViewById(R.id.blue)

        val hexFrag = HexFragment()
        val rgbFrag = RgbFragment()

        hexBtn.setOnClickListener() {
            var hex: String = hexValue.text.toString()
            var color: Int = Color.parseColor(hex)
            hexFrag.view?.setBackgroundColor(color)
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.flFragment, hexFrag)
                commit()
            }
        }
        rgbBtn.setOnClickListener() {
            var red: Int = redValue.text.toString().toInt()
            var green: Int = greenValue.text.toString().toInt()
            var blue: Int = blueValue.text.toString().toInt()

            rgbFrag.view?.setBackgroundColor(Color.rgb(red,green,blue))
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.flFragment, rgbFrag)
                commit()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1-> Toast.makeText(this,"RGB values are from 0-255", Toast.LENGTH_SHORT).show()
            R.id.item2-> Toast.makeText(this,"HEX format is #RRGGBB or #AARRGGBB", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}