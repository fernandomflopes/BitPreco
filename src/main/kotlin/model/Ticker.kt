package model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

data class Ticker (
    val high: BigDecimal,
    val low: BigDecimal,
    val last: BigDecimal,
    val vol: BigDecimal,
    @SerializedName("var") val variation: BigDecimal,
    @SerializedName("timestamp") val timeStamp: Date)