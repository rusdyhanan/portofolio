package com.example.keuanganku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class Adapter(var uangku: MutableList<ModelUangku>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    //    private var clickListener: ClickListener = clickListener
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_uangku, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position:
    Int) {
        holder.itemView.apply {
            var bukuModel = uangku.get(position)
            findViewById<TextView>(R.id.nominal).text = uangku[position].nominal.toString()
            findViewById<TextView>(R.id.deskripsi).text = uangku[position].deskripsi
            findViewById<TextView>(R.id.keterangan).text = uangku[position].keterangan
//            holder.itemView.setOnClickListener{
//                clickListener.clickedItem(bukuModel)
//            }
        }
    }
    override fun getItemCount(): Int {
        return uangku.size
    }
//    interface ClickListener{
//        fun clickedItem(BukuModel:BukuModel)
//    }
}

