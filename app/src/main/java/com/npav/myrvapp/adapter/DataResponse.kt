package com.npav.myrvapp.adapter

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("department_ID") var department_ID: Int,
    @SerializedName("departmentName") var departmentName: String?,
    @SerializedName("userId") var userId: String?,
    @SerializedName("Usersname") var usersname: String?

)

