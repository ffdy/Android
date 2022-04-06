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

class FindFragment : Fragment() {

    val TAG = "@@FindFragment"
    val finds = arrayListOf<Find>()

    class Find {
        var icon:Int = 0
        var name:String? = null
        var img:Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = FindAdapter(finds)

        Log.d(TAG, "onViewCreated")
    }

    private fun initData() {
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "朋友圈"
            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "视频号"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "扫一扫"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "摇一摇"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "看一看"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "搜一搜"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "直播和附近"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "购物"
//            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "游戏"
            img = R.drawable.ic_my
        })
        finds.add(Find().apply {
            icon = R.drawable.ic_find
            name = "小程序"
//            img = R.drawable.ic_my
        })
    }

    class FindAdapter(val finds: ArrayList<FindFragment.Find>) : RecyclerView.Adapter<FindAdapter.FindViewHolder>() {
        inner class FindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val iconImageView = itemView.findViewById<ImageView>(R.id.imageView)
            val nameTextView = itemView.findViewById<TextView>(R.id.desc)
            val imgImageView = itemView.findViewById<ImageView>(R.id.imageView2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindAdapter.FindViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_find, parent, false)
            return FindViewHolder(view)
        }

        override fun onBindViewHolder(holder: FindAdapter.FindViewHolder, position: Int) {
            val find = finds[position]
            holder.iconImageView.setImageResource(find.icon)
            holder.nameTextView.text = find.name
            holder.imgImageView.setImageResource(find.img)
        }

        override fun getItemCount(): Int {
            return finds.size
        }

    }

}