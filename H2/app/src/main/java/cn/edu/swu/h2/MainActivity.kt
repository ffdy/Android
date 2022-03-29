package cn.edu.swu.h2

import android.app.AlertDialog
import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG = "@@Mainactivity"

    private var username:String? = null
    private var password:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    /**
     * 为 EditText 添加文本监听器
     */
    private fun initView() {
        val inputUsernameEditText = findViewById<EditText>(R.id.ipt_username)
        val inputPasswordEditText = findViewById<EditText>(R.id.ipt_password)

        val usernameWatcher = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d(TAG, "before username changed : $p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d(TAG, "on username changed : $p0")
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d(TAG, "after username changed : $p0")
                username = p0.toString()
            }

        }

        val passwordWatcher = object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d(TAG, "before password changed : $p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d(TAG, "on password changed : $p0")
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d(TAG, "after password changed : $p0")
                password = p0.toString()
            }

        }

        // 也可以直接让类实现对应的接口
        inputUsernameEditText.addTextChangedListener(usernameWatcher)
        inputPasswordEditText.addTextChangedListener(passwordWatcher)

    }

    /**
     * 按钮绑定的函数
     */
    override fun onClick(view: View) {
        Log.d(TAG,"username = $username")
        Log.d(TAG,"password = $password")

        // 弹出框
        AlertDialog.Builder(this)
            .setTitle("确认登录")
            .setMessage("是否确认登录？")
            .setPositiveButton("确认") { _, _ ->
                login()
            }
            .setNegativeButton("取消") { _, _ ->
                Toast.makeText(this, "已取消", Toast.LENGTH_LONG)
                    .show()
            }
            .show()
    }

    private fun login() {
        val usernameEditText = findViewById<EditText>(R.id.ipt_username)
        val passwordEditText = findViewById<EditText>(R.id.ipt_password)
        val loginButton = findViewById<Button>(R.id.login_button)
        usernameEditText.visibility = View.GONE
        passwordEditText.visibility = View.GONE
        loginButton.visibility = View.GONE

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        progressBar.progress = 0

        // TODO: 网络请求相关

        val timer = Timer()
        val _this = this

        val task = object : TimerTask() {
            override fun run() {
                Log.d(TAG, "Progress: ${progressBar.progress}")
                progressBar.progress += 1
                if(progressBar.progress == 10) {
                    timer.cancel()
                    // 线程键操作
//                    runOnUiThread {
//                        progressBar.visibility = View.GONE
//                    }
                    // 推荐使用下面这种，会在合适的时候将执行该任务
                    Handler(Looper.getMainLooper()).post {
                        progressBar.visibility = View.GONE
                        startActivity(Intent(_this, ListsActivity::class.java))
                    }
                }

            }

        }
        timer.schedule(task, 0, 1000)
    }

}