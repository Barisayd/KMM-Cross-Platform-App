package com.example.ps_eis

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {
    private val httpClient = HttpClient()



    suspend fun greeting(): String{
        return "${getRequest()}"
    }



    suspend fun getRequest(): String {
        val response: HttpResponse = httpClient.get("https://gitcdn.link/cdn/KaterinaPetrova/greeting/7d47a42fc8d28820387ac7f4aaf36d69e434adc1/greetings.json")


        return response.bodyAsText()
    }
}