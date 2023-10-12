package com.example.keuanganku

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Serializable

class UangkuViewModel : ViewModel() {
    companion object {
        var listUangku = mutableListOf<ModelUangku>()
        var totalUangku : MutableLiveData<Int> = MutableLiveData<Int>(0)
    }

    fun hitungtotal(){
        var total = 0
        for(uang in listUangku){
//            totalUangku.value = totalUangku.value?.plus(uang.nominal)
            total += uang.nominal
        }
        totalUangku.value = total
    }
    fun tambahUangku(uangku: ModelUangku){
        val keterangan = uangku.keterangan
        listUangku.add(uangku)
        if(keterangan == "Pengeluaran"){
            totalUangku.value = totalUangku.value?.minus(uangku.nominal)
        }else{
            totalUangku.value = totalUangku.value?.plus(uangku.nominal)
        }
        Log.d("ViewModel", "Data berhasil ditambahkan")
    }
    fun hapusUangku(uangku: ModelUangku){
        listUangku.remove(uangku)
        hitungtotal()
        Log.d("ViewModel", "Data berhasil dihapus")
    }

    fun getUangku() = listUangku
    fun getTotalUang() = totalUangku
}