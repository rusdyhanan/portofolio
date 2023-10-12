package com.example.keuanganku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout

class Hutang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hutang)
        val vm_hutang = ViewModelProvider(this).get(HutangkuViewModel::class.java)
        val vm_uang = ViewModelProvider(this).get(UangkuViewModel::class.java)
        val tv_total = findViewById<TextView>(R.id.textView13)
        val HutangkuAdapter = HutangkuAdapter(HutangkuViewModel.listHutangku)
        val rv_hutangku = findViewById<RecyclerView>(R.id.recyclerView2)
        rv_hutangku.adapter = HutangkuAdapter
        rv_hutangku.layoutManager = LinearLayoutManager(this)
//        HutangkuViewModel.listHutangku.add(ModelHutangku("jeki",1))
//        vm_hutang.tambahHutang(ModelHutangku("jeki",1))
//        var totalhutang = 0
//        for(hutang in HutangkuViewModel.listHutangku){
////           HutangkuViewModel.totalHutang += hutang.nominal
//            totalhutang += hutang.nominal
//        }
//        HutangkuViewModel.totalHutang = vm_hutang.getTotalHutang()
        val btn_lunas = findViewById<Button>(R.id.button6)
        vm_hutang.getTotalHutang().observe(this,{
            tv_total.text = it.toString()
            if(it<=0){
                btn_lunas.isEnabled = false
                btn_lunas.setTextColor(resources.getColor(R.color.putih))
                btn_lunas.setBackgroundColor(resources.getColor(R.color.disabled))
            }
        })
//        if(vm_hutang.getHutang().isEmpty()){
//            btn_lunas.isEnabled = false
//            btn_lunas.setTextColor(resources.getColor(R.color.putih))
//            btn_lunas.setBackgroundColor(resources.getColor(R.color.disabled))
//        }
//        tv_total.setText("Rp."+HutangkuViewModel.totalHutang.value.toString())
        findViewById<Button>(R.id.button6).setOnClickListener {
            findViewById<ConstraintLayout>(R.id.constraintLayout3).isVisible = true
        }
        findViewById<Button>(R.id.button7).setOnClickListener {
            findViewById<ConstraintLayout>(R.id.constraintLayout3).isVisible = false
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            val et_nama = findViewById<TextInputLayout>(R.id.textInputLayout4)
            val et_nominal = findViewById<TextInputLayout>(R.id.textInputLayout5)
            val nama = et_nama.editText?.text.toString()
            val nominal = et_nominal.editText?.text.toString()
            if(nama.isNotEmpty() || nominal.length>0){
                val int: Int = nominal.toInt()
                vm_hutang.hapusHutang(ModelHutangku(nama,int))
                vm_uang.tambahUangku(ModelUangku(int,"Lunasi Hutang","Pengeluaran"))
                Toast.makeText(applicationContext,"utang dari "+nama+" Berhasil dilunasi",Toast.LENGTH_LONG).show()
//                Toast.makeText(applicationContext,vm_hutang.getHutang().size.toString(),Toast.LENGTH_LONG).show()
                et_nama.editText?.setText("")
                et_nominal.editText?.setText("")
                findViewById<ConstraintLayout>(R.id.constraintLayout3).isVisible = false
            }else{
                Toast.makeText(applicationContext,"Harap Data Diisi Lengkap",Toast.LENGTH_LONG).show()
            }

        }
    }
}