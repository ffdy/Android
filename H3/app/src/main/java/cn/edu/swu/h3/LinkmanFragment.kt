package cn.edu.swu.h3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class LinkmanFragment : Fragment() {
    val TAG = "@@LinkFragment"
    val linkmans = arrayListOf<Linkman>()

    class Linkman {
        var avator:Int = 0
        var name:String? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_linkman, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = LinkmanAppAdapter(linkmans)

        Log.d(TAG,"onViewCreated")
    }

    class LinkmanAppAdapter(val linkmans: ArrayList<LinkmanFragment.Linkman>) : RecyclerView.Adapter<LinkmanAppAdapter.LinkmanViewHolder>() {
        inner class LinkmanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val avatorImageView =  itemView.findViewById<ImageView>(R.id.imageView)
            val nameTextView = itemView.findViewById<TextView>(R.id.text_name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkmanViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_linkman, parent, false)
            return LinkmanViewHolder(view)
        }

        override fun onBindViewHolder(holder: LinkmanViewHolder, position: Int) {
            val linkman = linkmans[position]
            holder.avatorImageView.setImageResource(linkman.avator)
            holder.nameTextView.text = linkman.name
        }

        override fun getItemCount(): Int {
            return linkmans.size
        }
    }

    private fun initData() {
        linkmans.add(Linkman().apply {
            name = "Tom"
            avator = R.drawable.ic_my
        })
        linkmans.add(Linkman().apply {
            name = "Mary"
            avator = R.drawable.ic_my
        })
    }
}