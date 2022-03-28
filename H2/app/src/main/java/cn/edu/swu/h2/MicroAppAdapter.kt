package cn.edu.swu.h2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MicroAppAdapter(val microApps: List<MicroApp>) : RecyclerView.Adapter<MicroAppAdapter.MicroAppViewHolder>() {

    inner class MicroAppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val descTextView = itemView.findViewById<TextView>(R.id.desc)
        val priceTextView =  itemView.findViewById<TextView>(R.id.price_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MicroAppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return MicroAppViewHolder(view)
    }

    override fun onBindViewHolder(holder: MicroAppViewHolder, position: Int) {
        val microApp = microApps[position]
        holder.descTextView.text = microApp.desc
        holder.priceTextView.text = microApp.price
    }

    override fun getItemCount(): Int {
        return microApps.size
    }

}