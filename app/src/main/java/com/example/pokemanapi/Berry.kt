package com.example.pokemanapi

import com.google.gson.annotations.SerializedName

data class Berry(
    @SerializedName("name") var name : String,
    @SerializedName("url") var url  : String
)
data class Results(@SerializedName("count"    ) var count    : Int,
                   @SerializedName("next"     ) var next     : String,
                   @SerializedName("previous" ) var previous : String?,
                   @SerializedName("results"  ) var berry  : ArrayList<Berry>)