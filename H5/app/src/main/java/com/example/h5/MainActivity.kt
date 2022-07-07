package com.example.h5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.MessageDigest
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var inputText:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initView2()

        initView()
    }

//    private fun initView2() {
//        val appkey = "ac71a0c5a9ce70c5"
//        val btn = findViewById<Button>(R.id.btn_search)
//        val tranText = findViewById<TextView>(R.id.tran_result)
//        val editText = findViewById<EditText>(R.id.ipt)
//
//        Log.d("@@", "begin init")
//
//        editText.addTextChangedListener ( object:TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                Log.i("@@","beforeTextChanged : $s")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.i("@@","onTextChanged : $s")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                Log.i("@@","afterTextChanged : $s")
////                password = s?.toString()
//                inputText = s.toString()
//            }
//
//        } )
//
//        btn.setOnClickListener {
////            val telNumber = inputTelEt.text.toString()	//从EditText获取输入的手机号
//            val telService = ServiceCreator.create(TelService::class.java)  //传入之前定义的接口
//
//            //Get请求并处理结果
//            telService.SerachTelByGet(appkey, inputText).enqueue(object : Callback<Tel> {
//                override fun onFailure(call: Call<Tel>, t: Throwable) {
//                    t.printStackTrace()
//                }
//
//                override fun onResponse(call: Call<Tel>, response: Response<Tel>) {
//                    val tel = response.body()
//                    if (tel != null) {
////                        infoTv.text = "${tel.result.province}   ${tel.result.city}"
//                        tranText.text = tel.result.city+tel.result.province
//                    }
//                }
//            })
//        }
//    }

    private fun initView() {
        val btn = findViewById<Button>(R.id.btn_search)
        val tranText = findViewById<TextView>(R.id.tran_result)
        val editText = findViewById<EditText>(R.id.ipt)

        Log.d("@@", "begin init")

        editText.addTextChangedListener ( object:TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i("@@","beforeTextChanged : $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i("@@","onTextChanged : $s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i("@@","afterTextChanged : $s")
//                password = s?.toString()
                inputText = s.toString()
            }

        } )

        btn.setOnClickListener {
            val baiduTranApiServer = ServiceCreator.create(BaiduTranApiServer::class.java)
            Log.d("@@", "check button")

            val APPID = "20220706001266121"
            val SALT = "123456"
            val KEY = "STMw9LUYnIo6KZ0HWPYM"
            baiduTranApiServer.getTran(inputText, "en", "zh", APPID, SALT, md5(APPID+inputText+SALT+KEY))
                .enqueue(object : Callback<TranData> {
                    override fun onResponse(call: Call<TranData>, response: Response<TranData>) {
                        val tranData = response.body()
                        Log.d("@@", "getNetWork" + tranData.toString())
                        if (tranData != null) {
                            tranText.text = tranData.tranResult[0].dst+ ":" +tranData.tranResult[0].src
                        }

                    }

                    override fun onFailure(call: Call<TranData>, t: Throwable) {
                        Log.d("@@", "error")
                        t.printStackTrace()
                    }

                })
        }
    }

    fun md5(content: String): String {
        val hash = MessageDigest.getInstance("MD5").digest(content.toByteArray())
        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            var str = Integer.toHexString(b.toInt())
            if (b < 0x10) {
                str = "0$str"
            }
            hex.append(str.substring(str.length -2))
        }
        return hex.toString()
    }
}