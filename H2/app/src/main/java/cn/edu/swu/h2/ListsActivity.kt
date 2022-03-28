package cn.edu.swu.h2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListsActivity : AppCompatActivity() {

    private val microApps = arrayListOf<MicroApp>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lists)

        initData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MicroAppAdapter(microApps)
    }

    private fun initData() {
        microApps.add(MicroApp().apply {
            desc = "Apk安卓安装器"
            price = "免费"
            img = R.mipmap.img
        })
        microApps.add(MicroApp().apply {
            desc = "抖音电脑版"
            price = "免费"
            img = R.mipmap.img_1
        })
        microApps.add(MicroApp().apply {
            desc = "Ubuntu 20.04.4 LTS"
            price = "免费"
            img = R.mipmap.img_3
        })
        microApps.add(MicroApp().apply {
            desc = "APK 安装程序"
            price = "免费"
            img = R.mipmap.img_4
        })
        microApps.add(MicroApp().apply {
            desc = "Ubuntu"
            price = "免费"
            img = R.mipmap.img_2
        })
        microApps.add(MicroApp().apply {
            desc = "人人美剧UWP"
            price = "$78"
            img = R.mipmap.img_5
        })
        microApps.add(MicroApp().apply {
            desc = "AMD Link"
            price = "免费"
            img = R.mipmap.img_6
        })
        microApps.add(MicroApp().apply {
            desc = "闪电突袭：红警行动"
            price = "$23"
            img = R.mipmap.img_7
        })
        microApps.add(MicroApp().apply {
            desc = "酷酷视频UWP"
            price = "$120"
            img = R.mipmap.img_8
        })
    }
}