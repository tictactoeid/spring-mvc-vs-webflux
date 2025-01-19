package com.samsung.scholar.mvc.repository

import com.samsung.scholar.mvc.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>