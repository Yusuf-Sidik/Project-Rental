package com.example.rentalpetik.ui.pinjam

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rentalpetik.R

class PinjamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinjam)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Peminjaman"

        val spinner = findViewById<Spinner>(R.id.spinner)

        val items = listOf("Pilih Kendaraan","Mobil PeTIK", "Motor Blade", "Motor Vario", "Gerobak")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long
            ) {
                if (position != 0) {
                    val select = parent.getItemAtPosition(position).toString()
                    Toast.makeText(this@PinjamActivity, "Memilih $select", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> {super.onOptionsItemSelected(item)}
        }
    }
}