package model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

data class Trade (
        val type: String,
        val amount: BigDecimal,
        @SerializedName("timestamp") val timeStamp: Date,
        val price: BigDecimal
        )
