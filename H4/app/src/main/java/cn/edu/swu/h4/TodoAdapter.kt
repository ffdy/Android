package cn.edu.swu.h4

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(val todoList:List<TodoEntity>, val onClick: (TodoEntity) -> Unit):
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    val todos = ArrayList(todoList)

    class TodoViewHolder(
        itemView: View,
        val onClick: (TodoEntity) -> Unit,
        todoAdapter: TodoAdapter
    ) :
        RecyclerView.ViewHolder(itemView) {
        val desc = itemView.findViewById<TextView>(R.id.item_todo_text)
        val ddl = itemView.findViewById<TextView>(R.id.item_todo_time)
        val checkBox = itemView.findViewById<CheckBox>(R.id.item_todo_checkbox)
        var currentTodo: TodoEntity? = null

        init {
            itemView.setOnClickListener {
//                adapterPosition
                currentTodo?.let {
                    onClick(it)
                    it.done = it.done != true
                    todoAdapter.moveItem(it, adapterPosition)
//                    Thread() {
//                        MainActivity().db.todoDao().updateOne(it)
//                    }.start()
                    Log.d("@@db", "update")
                    val db = TodoDatabase.getInstance(MainActivity())
                    db.todoDao().updateOne(it)
                    checkBox.isChecked = it.done
                }
            }
        }
//        val checkBox = itemView.findViewById<CheckBox>(R.id.item_todo_checkbox).setOnCheckedChangeListener { compoundButton, isChecked -> {
//
//        } }
    }

    private fun moveItem(todoEntity: TodoEntity, position: Int) {
//        var item:Int = 0
        todos.removeAt(position)
        for(item in 0 until itemCount) {
//            if(item==position) continue
            if(todoEntity.done) {
                if(!todos[item].done) continue
                if(todos[item].created!! <= todoEntity.created) {
                    todos.add(item, todoEntity)
//                    todos.add(item, todoEntity)
//                    notifyItemInserted(item)
                    notifyItemMoved(position, item)
                    return
                }
            } else {
                if(todos[item].done) {
                    todos.add(item, todoEntity)
//                    todos.add(item, todoEntity)
//                    notifyItemInserted(item)
                    notifyItemMoved(position, item)
                    return
                }
                if(todos[item].deadline!! <= todoEntity.deadline) {
                    todos.add(item, todoEntity)
//                    todos.add(item, todoEntity)
//                    notifyItemInserted(item)
                    notifyItemMoved(position, item)
                    return
                }
            }
        }
        todos.add(todoEntity)
//                    todos.add(item, todoEntity)
//                    notifyItemInserted(item)
        notifyItemMoved(position, itemCount-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent, false)
        val holder = TodoViewHolder(view, onClick, this)
        return holder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.currentTodo = todo
        holder.desc.text = todo.description
        holder.ddl.text = todo.deadline.toString()
        holder.checkBox.isChecked = todo.done
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addItem(newTodo:TodoEntity) {

        todos.add(0, newTodo)
        notifyItemInserted(0)
    }

    fun doneItem(position: Int) {
        todos.removeAt(position)
        notifyItemRemoved(position)
    }

}