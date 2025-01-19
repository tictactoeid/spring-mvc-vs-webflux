package com.samsung.scholar.webflux.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class RequestService(
) {
    private val baseUrl = "http://127.0.0.1"
    fun sendGetRequest(targetApi: String, port: Int): Mono<String> {
        val webClient = WebClient.create("$baseUrl:$port")

        return webClient.get()
            .uri(targetApi)
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun sendPostRequest(body: Map<String, Any>, targetApi: String, port: Int): Mono<String> {
        val webClient = WebClient.create("$baseUrl:$port")

        return webClient.post()
            .uri(targetApi)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(String::class.java)
    }
}