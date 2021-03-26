import bitpreco.BitPreco


fun main() {

    BitPreco().getTrades().forEach {
        println(it.price)
    }
}