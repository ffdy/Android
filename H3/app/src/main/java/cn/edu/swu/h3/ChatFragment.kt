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

class ChatFragment : Fragment() {

    val TAG = "@@ChatFragment"
    val chats = arrayListOf<Chat>()

    class Chat {
        var avator:Int = 0
        var name:String? = null
        var lastChat:String? = null
        var time:String? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ChatAppAdapter(chats)

        Log.d(TAG,"onViewCreated")
    }

    class ChatAppAdapter(val chats: ArrayList<ChatFragment.Chat>) : RecyclerView.Adapter<ChatAppAdapter.ChatViewHolder>() {
        inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val avatorImageView =  itemView.findViewById<ImageView>(R.id.imageView)
            val nameTextView = itemView.findViewById<TextView>(R.id.text_name)
            val lastChatTextView =  itemView.findViewById<TextView>(R.id.text_chat)
            val timeTextView = itemView.findViewById<TextView>(R.id.text_chat_time)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
            return ChatViewHolder(view)
        }

        override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
            val chat = chats[position]
            holder.avatorImageView.setImageResource(chat.avator)
            holder.nameTextView.text = chat.name
            holder.lastChatTextView.text = chat.lastChat
            holder.timeTextView.text = chat.time
        }

        override fun getItemCount(): Int {
            return chats.size
        }
    }

    private fun initData() {
        chats.add(Chat().apply {
            name = "Tom"
            avator = R.drawable.ic_my
            lastChat = "Good morning!"
            time = "8:30"
        })
        chats.add(Chat().apply {
            name = "Mary"
            avator = R.drawable.ic_my
            lastChat = "Good night!"
            time = "21:30"
        })
    }
}