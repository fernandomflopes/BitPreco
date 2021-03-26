package model

import java.math.BigDecimal

data class Order(
    val amount: BigDecimal,
    val price: BigDecimal,
    val id: String
)
