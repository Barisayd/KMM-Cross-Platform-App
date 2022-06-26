package com.example.ps_eis.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ps_eis.CodeClass

class QrCodeAdapter(private val codeList : ArrayList<CodeClass>) : RecyclerView.Adapter<QrCodeAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.qrcode_item,
            parent,false)
        return MyViewHolder(itemView)

    }
    override fun getItemCount() = codeList.size



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem: CodeClass = codeList[position]

        holder.result.text = currentItem.result


    }

    public class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val result : TextView = itemView.findViewById(R.id.result)



    }


}