package com.example.h5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TelService {

    /**
     * @Parent: appkey: 调用的密钥      shouji: 查询的手机号
     */
    @GET("shouji/query")
    fun SerachTelByGet(@Query("appkey") appkey: String, @Query("shouji") shouji: String): Call<Tel>
}
