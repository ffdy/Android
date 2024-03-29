package cn.edu.swu.h3

import android.app.ActionBar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    val TAG = "@@MainActivity"

    lateinit var manager: FragmentManager
    val fragmentList = arrayListOf<Fragment>()

    companion object TAGS{
        val TAG_CHAT = "chat"
        val TAG_LINKMAN = "linkman"
        val TAG_FIND = "find"
        val TAG_MY = "my"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.hide()

        initView()
    }

    private fun initView() {
        manager = supportFragmentManager
        showFragment(TAG_CHAT)
    }

    fun showFragment(tag:String) {
        val tran = manager.beginTransaction()

        if(tag == TAG_CHAT) {
            tran.replace(R.id.fragment_container_view, ChatFragment()).commit()
        } else if (tag == TAG_LINKMAN) {
            tran.replace(R.id.fragment_container_view, LinkmanFragment()).commit()
        } else if (tag == TAG_FIND) {
            tran.replace(R.id.fragment_container_view, FindFragment()).commit()
        } else if (tag == TAG_MY) {
            tran.replace(R.id.fragment_container_view, MyFragment()).commit()
        }

    }
}