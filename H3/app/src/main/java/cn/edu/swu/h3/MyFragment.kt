package cn.edu.swu.h3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MyFragment : Fragment() {

    val myApps = arrayListOf<MyApp>()

    class MyApp {
        var icon:Int = 0
        var name:String? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MyAppAdapter(myApps)
    }

    class MyAppAdapter(val myApps: ArrayList<MyApp>) : RecyclerView.Adapter<MyAppAdapter.MyAppViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAppAdapter.MyAppViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my, parent, false)
            return MyAppViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyAppAdapter.MyAppViewHolder, position: Int) {
            val myApp = myApps[position]
            holder.iconImageView.setImageResource(myApp.icon)
            holder.nameTextView.text = myApp.name
        }

        inner class MyAppViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            val iconImageView = itemView.findViewById<ImageView>(R.id.imageView)
            val nameTextView = itemView.findViewById<TextView>(R.id.desc)
        }

        override fun getItemCount(): Int {
            return myApps.size
        }

    }

    private fun initData() {
        myApps.add(MyApp().apply {
            icon = R.drawable.ic_find
            name = "服务"
        })
        myApps.add(MyApp().apply {
            icon = R.drawable.ic_find
            name = "收藏"
        })
        myApps.add(MyApp().apply {
            icon = R.drawable.ic_find
            name = "朋友圈"
        })
        myApps.add(MyApp().apply {
            icon = R.drawable.ic_find
            name = "卡包"
        })
        myApps.add(MyApp().apply {
            icon = R.drawable.ic_find
            name = "表情"
        })
        myApps.add(MyApp().apply {
            icon = R.drawable.ic_find
            name = "设置"
        })
    }
}