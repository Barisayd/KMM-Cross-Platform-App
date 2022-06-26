package com.example.ps_eis

import io.ktor.client.*

import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

import kotlinx.serialization.Serializable
import io.ktor.serialization.kotlinx.json.*

import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

class Client {

    val httpClient = HttpClient() {


    }



    suspend fun greeting(): String{
        return "${getRequest()}"
    }



    suspend fun getRequest(): String {
        val response: HttpResponse = httpClient.get("https://jsonplaceholder.typicode.com/posts")







        return response.bodyAsText()
    }
}