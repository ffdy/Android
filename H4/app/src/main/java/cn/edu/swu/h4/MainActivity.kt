package cn.edu.swu.h4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var db:TodoDatabase
    lateinit var recyclerTodo:RecyclerView
    lateinit var todoAdapter:TodoAdapter
    lateinit var inputDesc: String
//    lateinit var recyclerDone:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        db = TodoDatabase.getInstance(this)

//        initData()
        initView()
        initTitleView()

    }

    private fun initTitleView() {
            val ipt = findViewById<EditText>(R.id.ipt)
            val btn = findViewById<Button>(R.id.btn_add)

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
                    inputDesc = s.toString()
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
//                TodoDatabase.getInstance(MainActivity()).todoDao().insertOne(newTodo)
//            MainActivity().todoAdapter.notifyItemInserted()
                db.todoDao().insertOne(newTodo)
                todoAdapter.addItem(newTodo)
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

    private fun initView() {
//        val todos:List<TodoEntity> = db.todoDao().getAll()
//        val todoDao = db.todoDao();
        val todoList = ArrayList(db.todoDao().getAll())
        recyclerTodo = findViewById<RecyclerView>(R.id.recyclerView_todo)
        recyclerTodo.layoutManager = LinearLayoutManager(this)
        Log.d("@@", "init adapter")

        todoAdapter = TodoAdapter(
//            ArrayList.union(db.todoDao().getAllTodo(),db.todoDao().getAllDone())
//            db.todoDao().getAllTodo().addAll(db.todoDao().getAllDone())
            todoList
        ) {

            todoEntity ->  todoOnClick(todoEntity)
        }
        recyclerTodo.adapter = todoAdapter
//        recyclerTodo.adapter.no
//        todoList.add()
//        recyclerTodo.adapter.notifyItemInserted(recyclerTodo.adapter.itemCount)
//        todoadapter.addItem(TodoEntity(0, "1234", Date(), Date(), false))

//        ItemClickSupport

//        val nowTime = java.util.Date()
//        Log.d("@@", nowTime.toString())
//        todoDao.insertOne(TodoEntity(0, "test", nowTime, nowTime, false))
//
//        Log.d("@@", todos.toString())
    }

    private fun todoOnClick(todoEntity: TodoEntity) {
//        Thread() {
//            if(todoEntity.done) {
//                todoEntity.done = false
//                db.todoDao().updateOne(todoEntity)
//            } else {
//                todoEntity.done = true
//                db.todoDao().updateOne(todoEntity)
//            }
//        }
    }


    private fun initData() {
        for (i in 0..10) {
            db.todoDao().insertOne(TodoEntity(0,"todo" + i.toString(), java.util.Date(), java.util.Date(), true))
        }
    }
}