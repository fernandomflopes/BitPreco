package bitpreco

import com.google.gson.GsonBuilder
import model.OrderBook
import model.Ticker
import model.Trade
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class BitPreco {

    val API_URL = "https://api.bitpreco.com/btc-brl/"
    val TICKER_URL = API_URL + "ticker"
    val ORDERBOOK_URL = API_URL + "orderbook"
    val TRADES_URL = API_URL + "trades"

    private fun executeRequest(url : String) : Response {
        val client = OkHttpClient()
        val req = Request.Builder()
            .url(url)
            .build()

        return client.newCall(req).execute()
    }

    private fun executeRequestTicker(): Response = executeRequest(TICKER_URL)
    private fun executeRequestOrderBook(): Response = executeRequest(ORDERBOOK_URL)
    private fun executeRequestTrades(): Response = executeRequest(TRADES_URL)

    private fun getGsonBuilder() : GsonBuilder = GsonBuilder().apply {
            this.setDateFormat("yyyy-MM-dd HH:mm:ss")
        }


    fun getTicker() : Ticker = getGsonBuilder()
                                .create()
                                .fromJson(executeRequestTicker().body?.string(), Ticker::class.java)

    fun getOrderBook() : OrderBook = getGsonBuilder()
        .create()
        .fromJson(executeRequestOrderBook().body?.string(), OrderBook::class.java)

    fun getTrades() : Array<Trade> = getGsonBuilder()
            .create()
            .fromJson(executeRequestTrades().body?.string(), Array<Trade>::class.java)

}