package com.samsung.scholar.mvc.controller

import com.samsung.scholar.mvc.service.RequestService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sync/to/sync")
class SyncController(
    private val requestService: RequestService,
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): String =
        requestService.sendGetRequest("/mvc/user/$id", 8080)

    @PostMapping
    fun createUser(@RequestBody body: Map<String, Any>): String =
        requestService.sendPostRequest(body, "/mvc/user", 8080)

    @GetMapping("/all")
    fun getAllUsers(): String =
        requestService.sendGetRequest("/mvc/user/all", 8080)
}

