package com.example.keuanganku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class TambahPemasukan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pemasukan)
        val vm_hutang = ViewModelProvider(this).get(HutangkuViewModel::class.java)
        val vm_uang = ViewModelProvider(this).get(UangkuViewModel::class.java)
        var utang = false
        val et_nama = findViewById<TextInputLayout>(R.id.textInputLayout3)
        val et_nominal = findViewById<TextInputLayout>(R.id.textInputLayout)
        val et_deskripsi = findViewById<TextInputLayout>(R.id.textInputLayout2)
        findViewById<Button>(R.id.button5).setOnClickListener {
            et_nama.isVisible = true
            utang = true
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            val nominal = et_nominal.editText?.text.toString()
            val deskripsi = et_deskripsi.editText?.text.toString()
            val nama = et_nama.editText?.text.toString()
            if(nominal.isNotEmpty() || deskripsi.isNotEmpty()){
                val int: Int = nominal.toInt()
                if(utang){
                    if(nama.isNotEmpty()){
                        vm_uang.tambahUangku(ModelUangku(int,deskripsi,"Pemasukan"))
                        vm_hutang.tambahHutang(ModelHutangku(nama,int))
                        Toast.makeText(applicationContext,"Pemasukan Berhasil Ditambahkan", Toast.LENGTH_LONG).show()
                        et_nominal.editText?.setText("")
                        et_deskripsi.editText?.setText("")
                        et_nama.editText?.setText("")
                        et_nama.isVisible = false
                    }else{
                        Toast.makeText(applicationContext,"Harap Data Diisi Lengkap", Toast.LENGTH_LONG).show()
                    }
                }else{
                    vm_uang.tambahUangku(ModelUangku(int,deskripsi,"Pemasukan"))
                    Toast.makeText(applicationContext,"Pemasukan Berhasil Ditambahkan", Toast.LENGTH_LONG).show()
                    et_nominal.editText?.setText("")
                    et_deskripsi.editText?.setText("")
                    et_nama.editText?.setText("")
                }

            }else{
                Toast.makeText(applicationContext,"Harap Data Diisi Lengkap", Toast.LENGTH_LONG).show()
            }
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            finish()
        }
    }
}