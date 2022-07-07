package cn.edu.swu.h4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import org.greenrobot.eventbus.EventBus
import java.util.*

class TitleFragment : Fragment() {

    lateinit var todoAdapter: TodoAdapter
    var inputDesc:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)
//        EventBus.getDefault().register(this)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
//        view.findViewById<Button>(R.id.btn_life).setOnClickListener(this)
//        view.findViewById<Button>(R.id.btn_work).setOnClickListener(this)
    }

    private fun initView(view: View) {
        val ipt = view.findViewById<EditText>(R.id.ipt)
        val btn = view.findViewById<Button>(R.id.btn_add)

        val iptWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i("@@","beforeTextChanged : $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i("@@","onTextChanged : $s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i("@@","afterTextChanged : $s")
//                password = s?.toString()
                inputDesc = s?.toString()
            }
        }

        ipt.addTextChangedListener(iptWatcher)
        btn.setOnClickListener {
            val newTodo = TodoEntity(0, inputDesc, Date(), Date(), false)
//            recyclerView?.adapter.add
//            recyclerView
            Log.d("@@", "check add btn")

//            Thread() {
//                MainActivity().db.todoDao().insertOne(newTodo)
//            }
            TodoDatabase.getInstance(MainActivity()).todoDao().insertOne(newTodo)
//            MainActivity().todoAdapter.notifyItemInserted()
//            MainActivity().todoAdapter.addItem(newTodo)
        }
//        val iptUsername = findViewById<EditText>(R.id.ipt_username)
//        val iptPassword = findViewById<EditText>(R.id.ipt_password)
//        val passwordWatcher = object:TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                Log.i(TAG,"beforeTextChanged : $s")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.i(TAG,"onTextChanged : $s")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                Log.i(TAG,"afterTextChanged : $s")
//                password = s?.toString()
//            }
//        }

//        iptUsername.addTextChangedListener(usernameWatcher)
//        iptPassword.addTextChangedListener(passwordWatcher)
    }

}