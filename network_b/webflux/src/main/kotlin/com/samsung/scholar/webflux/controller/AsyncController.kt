package com.samsung.scholar.webflux.controller

import com.samsung.scholar.webflux.service.RequestService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/async/to/async")
class AsyncController(
    private val requestService: RequestService,
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): Mono<String>
        = requestService.sendGetRequest("/webflux/user/$id", 8081)

    @GetMapping("/all")
    fun getAllUsers(): Mono<String>
        = requestService.sendGetRequest("/webflux/user/all", 8081)

    @PostMapping
    fun createUser(@RequestBody body: Map<String, Any>): Mono<String>
        = requestService.sendPostRequest(body, "/webflux/user", 8081)
}