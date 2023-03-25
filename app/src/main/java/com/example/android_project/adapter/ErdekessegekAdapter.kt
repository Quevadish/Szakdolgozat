package com.example.android_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.model.infoviewmodel

class ErdekessegekAdapter (private val infoList : ArrayList<infoviewmodel>) :
    RecyclerView.Adapter<ErdekessegekAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.erdekessegekdesign,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val infocurrentItem = infoList[position]
        holder.fej.text = infocurrentItem.FEJ
        holder.brief.text = infocurrentItem.brief

        val isvisible : Boolean = infocurrentItem.visibility
        holder.constraintLayout.visibility = if(isvisible) View.VISIBLE else View.GONE

        holder.fej.setOnClickListener{
            infocurrentItem.visibility = !infocurrentItem.visibility
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val fej :  TextView  = itemView.findViewById(R.id.fej)
        val brief : TextView = itemView.findViewById(R.id.tartalom)
        val constraintLayout : ConstraintLayout = itemView.findViewById(R.id.expandedLayout)

    }

}