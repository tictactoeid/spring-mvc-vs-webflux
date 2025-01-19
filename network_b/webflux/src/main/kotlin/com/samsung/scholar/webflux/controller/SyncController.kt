package com.samsung.scholar.webflux.controller

import com.samsung.scholar.webflux.service.RequestService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/async/to/sync")
class SyncController(
    private val requestService: RequestService,
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): Mono<String>
        = requestService.sendGetRequest("/mvc/user/$id", 8080)

    @GetMapping("/all")
    fun getAllUsers(): Mono<String>
        = requestService.sendGetRequest("/mvc/user/all", 8080)

    @PostMapping
    fun createUser(@RequestBody body: Map<String, Any>): Mono<String>
        = requestService.sendPostRequest(body, "/mvc/user", 8080)
}