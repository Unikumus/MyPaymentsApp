package com.unikumus.mypayments.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unikumus.mypayments.R
import com.unikumus.mypayments.models.Payments
import com.unikumus.mypayments.models.Response
import kotlinx.android.synthetic.main.layout_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Response>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val gb:Double  = (myList[position].amount.toString().toDouble())
        val output1= (gb * 100.0).roundToInt() / 100.0;

        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date: String = simpleDateFormat.format(myList[position].created)



        holder.itemView.id_amount.text = output1.toString()
        holder.itemView.id_desc.text = myList[position].desc
        holder.itemView.id_currency.text = myList[position].currency
        holder.itemView.id_created.text = date.toString()
    }

    fun setData(newList: Payments){
        myList = newList.response
        notifyDataSetChanged()
    }
}
