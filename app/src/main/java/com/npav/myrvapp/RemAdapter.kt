package com.npav.myrvapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RemAdapter(val context: Context, val listOfRemModel: List<RemModel>, val remCallback: RemCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        populateData(holder as MyViewHolder, position)
    }

    private fun populateData(holder: RemAdapter.MyViewHolder, position: Int) {
            val RemModel = listOfRemModel.get(position)

        holder.tv_remtitle.setText(RemModel.remTitle)
        holder.tv_remtext.setText(RemModel.remDesc)

        holder.cv_main.setOnClickListener(View.OnClickListener {remCallback.executeOnClick()  })

    }

    override fun getItemCount(): Int {
        return listOfRemModel.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_remtitle: TextView = itemView.findViewById(R.id.tv_remtitle)
        val tv_remtext: TextView = itemView.findViewById(R.id.tv_remtext)
        val cv_main: CardView = itemView.findViewById(R.id.cv_main)
    }

    interface RemCallback{
        fun executeOnClick()
    }

}