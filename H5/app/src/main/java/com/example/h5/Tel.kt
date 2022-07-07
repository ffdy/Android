package com.example.h5

data class Tel(val status: String, val msg: String, val result: Result) {
    data class Result(
        val province: String,       // 省
        val city: String,           // 市
        val company: String,        // 运营商
        val cardtype: String        // 卡类型
    )
}

