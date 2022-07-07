package com.example.h5

import com.google.gson.annotations.SerializedName

data class TranData (var from:String, var to:String,
                     @SerializedName("trans_result")var tranResult: List<TranResult>)