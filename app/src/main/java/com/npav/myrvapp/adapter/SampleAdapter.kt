package com.npav.myrvapp.adapter

import android.content.Context
import android.content.pm.PackageManager
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.npav.myrvapp.R
import java.io.File

class SampleAdapter(
    val dataList: List<DataResponse>,
    val context: Context,
    val sampleCallback: SampleCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_view1 = itemView.findViewById<TextView>(R.id.tv_view1)
        val tv_view2 = itemView.findViewById<TextView>(R.id.tv_view2)
        val tv_view3 = itemView.findViewById<TextView>(R.id.tv_view3)
        val tv_view4 = itemView.findViewById<TextView>(R.id.tv_view4)
        val cv_main = itemView.findViewById<CardView>(R.id.cv_main1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_sampledata_itemview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        populateData(holder as MyViewHolder, position)
    }

    private fun populateData(holder: MyViewHolder, position: Int) {
        val data = dataList.get(position)
        holder.tv_view1.setText(data?.usersname)
        holder.tv_view2.setText(data?.userId.toString())
        holder.tv_view3.setText(data?.departmentName.toString())
        holder.tv_view4.setText(data?.department_ID.toString())

     /*   if (dataClass?.arg5 == true) {
            holder.tv_view4.setBackgroundColor(context.resources.getColor(R.color.purple_200))
        }*/

        holder.cv_main.setOnClickListener(View.OnClickListener {
            data?.departmentName?.let { it1 -> sampleCallback.executeOnClick(it1) }
        })


    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    interface SampleCallback {
        fun executeOnClick(name: String)
    }

}