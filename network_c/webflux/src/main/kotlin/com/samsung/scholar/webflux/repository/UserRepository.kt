package com.samsung.scholar.webflux.repository

import com.samsung.scholar.webflux.entity.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: ReactiveCrudRepository<User, Long> {
}