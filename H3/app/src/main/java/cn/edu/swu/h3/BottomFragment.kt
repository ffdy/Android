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

class BottomFragment : Fragment(), View.OnClickListener {

    val TAG = "@@BottomFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)

        Log.d(TAG,"onViewCreated")
    }

    private fun initView(view : View) {
        val chatBottom = view.findViewById<ImageView>(R.id.b_chat)
        val linkmanBottom = view.findViewById<ImageView>(R.id.b_linkman)
        val findBottom = view.findViewById<ImageView>(R.id.b_find)
        val myBottom = view.findViewById<ImageView>(R.id.b_my)

        chatBottom.setImageResource(R.drawable.ic_chat_black)

        chatBottom.setOnClickListener(this)
        linkmanBottom.setOnClickListener(this)
        findBottom.setOnClickListener(this)
        myBottom.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val act =  requireActivity() as MainActivity

        val chatBottom = act.findViewById<ImageView>(R.id.b_chat)
        chatBottom.setImageResource(R.drawable.ic_chat)
        val linkmanBottom = act.findViewById<ImageView>(R.id.b_linkman)
        linkmanBottom.setImageResource(R.drawable.ic_linkman)
        val findBottom = act.findViewById<ImageView>(R.id.b_find)
        findBottom.setImageResource(R.drawable.ic_find)
        val myBottom = act.findViewById<ImageView>(R.id.b_my)
        myBottom.setImageResource(R.drawable.ic_my)

        when(view.id) {
            R.id.b_chat-> {
                act.showFragment("chat")
                chatBottom.setImageResource(R.drawable.ic_chat_black)
            }
            R.id.b_linkman-> {
                act.showFragment("linkman")
                linkmanBottom.setImageResource(R.drawable.ic_linkman_black)
            }
            R.id.b_find-> {
                act.showFragment("find")
                findBottom.setImageResource(R.drawable.ic_find_black)
            }
            R.id.b_my-> {
                act.showFragment("my")
                myBottom.setImageResource(R.drawable.ic_my_black)
            }
        }
    }
}