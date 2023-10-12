package com.example.keuanganku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class TambahPengeluaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengeluaran)
        val vm_uang = ViewModelProvider(this).get(UangkuViewModel::class.java)
        val et_nominal = findViewById<TextInputLayout>(R.id.textInputLayout6)
        val et_deskripsi = findViewById<TextInputLayout>(R.id.textInputLayout7)
        findViewById<Button>(R.id.button9).setOnClickListener {
            finish()
        }
        findViewById<Button>(R.id.button10).setOnClickListener {
            val nominal = et_nominal.editText?.text.toString()
            val deskripsi = et_deskripsi.editText?.text.toString()
            if(nominal.isNotEmpty() || deskripsi.isNotEmpty()){
                val int: Int = nominal.toInt()
                vm_uang.tambahUangku(ModelUangku(int,deskripsi,"Pengeluaran"))
                Toast.makeText(applicationContext,"Pemasukan Berhasil Ditambahkan", Toast.LENGTH_LONG).show()
                et_nominal.editText?.setText("")
                et_deskripsi.editText?.setText("")
            }else{
                Toast.makeText(applicationContext,"Harap Data Diisi Lengkap", Toast.LENGTH_LONG).show()
            }

        }
    }

}