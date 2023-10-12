package com.example.keuanganku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uangku = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val hutangku = findViewById<ConstraintLayout>(R.id.constraintLayout3)
        val tambah_pemasukkan= findViewById<Button>(R.id.button)
        val tambah_pengeluaran = findViewById<Button>(R.id.button2)
        val tv_totalUang = findViewById<TextView>(R.id.totalUang)
        val tv_totalHutang = findViewById<TextView>(R.id.totalHutang)
        var vm_uang = ViewModelProvider(this).get(UangkuViewModel::class.java)
        var vm_hutang = ViewModelProvider(this).get(HutangkuViewModel::class.java)
//        var totalUang = 0
//        var totalHutang = 0
//        for (uang in UangkuViewModel.listUangku){
//            totalUang += uang.nominal
//        }
//        for (hutang in HutangkuViewModel.listHutangku){
//            totalHutang += hutang.nominal
//        }
//        tv_totalUang.setText(totalUang.toString())
//        tv_totalHutang.setText(totalHutang.toString())
        vm_hutang.getTotalHutang().observe(this,{
            tv_totalHutang.text = it.toString()
        })
        vm_uang.getTotalUang().observe(this,{
            tv_totalUang.text = it.toString()
        })
        uangku.setOnClickListener {
            intent = Intent(this, Uangku::class.java)
            startActivity(intent)
        }
        hutangku.setOnClickListener {
            intent = Intent(this, Hutang::class.java)
            startActivity(intent)
        }
        tambah_pemasukkan.setOnClickListener {
            intent = Intent(this, TambahPemasukan::class.java)
            startActivity(intent)
        }
        tambah_pengeluaran.setOnClickListener {
            intent = Intent(this, TambahPengeluaran::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }
}