package com.example.keuanganku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class HutangkuAdapter(var hutangku: MutableList<ModelHutangku>) :
    RecyclerView.Adapter<HutangkuAdapter.ViewHolder>() {
    //    private var clickListener: ClickListener = clickListener
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hutangku, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position:
    Int) {
        holder.itemView.apply {
//            var bukuModel = hutangku.get(position)
            findViewById<TextView>(R.id.textView10).text = hutangku[position].nama
            findViewById<TextView>(R.id.textView12).text = hutangku[position].nominal.toString()
//            findViewById<TextView>(R.id.keterangan).text = hutangku[position].keterangan
//            holder.itemView.setOnClickListener{
//                clickListener.clickedItem(bukuModel)
//            }
        }
    }
    override fun getItemCount(): Int {
        return hutangku.size
    }

//    interface ClickListener{
//        fun clickedItem(BukuModel:BukuModel)
//    }
}

