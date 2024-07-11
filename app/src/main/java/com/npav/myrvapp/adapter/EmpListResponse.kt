package com.npav.myrvapp.adapter

import com.google.gson.annotations.SerializedName

data class EmpListResponse(
    @SerializedName("status") var status: Boolean,
    @SerializedName("message") var message: String?,
    @SerializedName("data") var data: List<DataResponse>
)
