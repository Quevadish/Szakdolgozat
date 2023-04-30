package com.example.android_project.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.model.ItemsViewModel
import com.google.android.material.imageview.ShapeableImageView

class CustomAdapter (private val mList : ArrayList<ItemsViewModel>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = mList[position]
        holder.image.setImageResource(currentItem.image)
        holder.text.text = currentItem.text
        holder.szoveg.text= currentItem.madartartalom


        val visible : Boolean = currentItem.lathatosag
        holder.constraintLayout.visibility = if(visible) View.VISIBLE else View.GONE

        holder.image.setOnClickListener{
            currentItem.lathatosag = !currentItem.lathatosag
            notifyItemChanged(position)
        }



    }

    override fun getItemCount(): Int {
        return mList.size
    }



    class MyViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val image : ShapeableImageView = itemView.findViewById(R.id.madarkep)
        val text : TextView = itemView.findViewById(R.id.madarnev)
        val szoveg : TextView = itemView.findViewById(R.id.madartartalom)
        val constraintLayout : ConstraintLayout = itemView.findViewById(R.id.madarexpandedLayout)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }

}