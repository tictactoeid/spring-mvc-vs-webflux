package com.samsung.scholar.webflux.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user")
data class User(
    @Id
    val id: Long? = null,
    val name: String,
    val email: String,
)
