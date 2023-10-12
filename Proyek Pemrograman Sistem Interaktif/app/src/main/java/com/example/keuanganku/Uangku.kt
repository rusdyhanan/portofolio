package com.example.keuanganku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Uangku : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uangku)
        val viewModel = ViewModelProvider(this).get(UangkuViewModel::class.java)
        val tv_total = findViewById<TextView>(R.id.textView6)
        val UangkuAdapter = Adapter(UangkuViewModel.listUangku)
        val rv_uangku = findViewById<RecyclerView>(R.id.recyclerView)
        var totalUang = 0
        rv_uangku.adapter = UangkuAdapter
        rv_uangku.layoutManager = LinearLayoutManager(this)
//        UangkuViewModel.listUangku.add(ModelUangku(1,"2","3"))
//        viewModel.tambahUangku(ModelUangku(1,"2","3"))
        viewModel.getTotalUang().observe(this,{
            tv_total.text = it.toString()
        })
//        for(uang in UangkuViewModel.listUangku){
//                totalUang += uang.nominal
//        }
//        UangkuViewModel.totalUangku.value = totalUang
//        tv_total.setText(UangkuViewModel.totalUangku.toString())

    }
}