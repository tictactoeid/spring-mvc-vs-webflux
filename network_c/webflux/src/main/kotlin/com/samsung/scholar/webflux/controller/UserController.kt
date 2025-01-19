package com.samsung.scholar.webflux.controller

import com.samsung.scholar.webflux.entity.User
import com.samsung.scholar.webflux.repository.UserRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/webflux/user")
class UserController(
    private val userRepository: UserRepository,
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): Mono<User> =
        userRepository.findById(id)

    @PostMapping
    fun createUser(@RequestBody user: User): Mono<User> =
        userRepository.save(user)

    @GetMapping("/all")
    fun getAllUsers(): Flux<User> =
        userRepository.findAll()
}