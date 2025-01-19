package com.samsung.scholar.mvc.controller

import com.samsung.scholar.mvc.service.RequestService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sync/to/async")
class AsyncController(
    private val requestService: RequestService,
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): String =
        requestService.sendGetRequest("/webflux/user/$id", 8081)

    @PostMapping
    fun createUser(@RequestBody body: Map<String, Any>): String =
        requestService.sendPostRequest(body, "/webflux/user", 8081)

    @GetMapping("/all")
    fun getAllUsers(): String =
        requestService.sendGetRequest("/webflux/user/all", 8081)
}

