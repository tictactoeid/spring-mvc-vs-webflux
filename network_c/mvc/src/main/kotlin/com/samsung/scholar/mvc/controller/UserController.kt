package com.samsung.scholar.mvc.controller

import com.samsung.scholar.mvc.CustomException
import com.samsung.scholar.mvc.UserNotFoundException
import com.samsung.scholar.mvc.entity.User
import com.samsung.scholar.mvc.repository.UserRepository
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mvc/user")
class UserController(
    private val userRepository: UserRepository,
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User =
        userRepository.findById(id).orElseThrow{ UserNotFoundException() }

    @PostMapping
    fun createUser(@RequestBody user: User) =
        userRepository.save(user)

    @GetMapping("/all")
    fun getAllUsers(): List<User> =
        userRepository.findAll()
}