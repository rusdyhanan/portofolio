package com.example.keuanganku

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Serializable

class HutangkuViewModel : ViewModel() {
    companion object {
        var listHutangku = mutableListOf<ModelHutangku>()
        var totalHutang: MutableLiveData<Int> = MutableLiveData<Int>(0)
    }


    fun hitungtotal(){
        var total = 0
        for(hutang in listHutangku){
            total+= hutang.nominal
//            totalHutang.value = totalHutang.value?.plus(hutang.nominal)
        }
        totalHutang.value = total
    }

    fun tambahHutang(hutangku: ModelHutangku){
        listHutangku.add(hutangku)
        hitungtotal()
        Log.d("ViewModel", "Data berhasil ditambahkan")
    }
    fun hapusHutang(hutangku: ModelHutangku){
        listHutangku.remove(hutangku)
        hitungtotal()
    }

    fun getHutang() = listHutangku
    fun getTotalHutang() = totalHutang
}