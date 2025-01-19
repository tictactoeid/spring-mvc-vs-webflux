package com.samsung.scholar.mvc.service

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RequestService(
    private val restTemplate: RestTemplate,
) {
    private val address = "127.0.0.1"

    fun sendGetRequest(targetApi: String, port: Int): String {
        val targetUrl = "http://$address:$port$targetApi"
        return restTemplate.getForObject(targetUrl, String::class.java) ?: "No data"
    }

    fun sendPostRequest(requestBody: Map<String, Any>, targetApi: String, port: Int): String {
        val targetUrl = "http://$address:$port$targetApi" // FIXME
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }
        val entity = HttpEntity(requestBody, headers)

        val response = restTemplate.exchange(targetUrl, HttpMethod.POST, entity, String::class.java)
        return response.body ?: "No response"
    }
}