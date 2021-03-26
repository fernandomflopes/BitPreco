package model

import com.google.gson.annotations.SerializedName
import java.util.*

data class OrderBook(
    val success: Boolean,
    val bids: Array<Order>,
    val asks: Array<Order>,
    @SerializedName("timestamp") val timeStamp: Date
)