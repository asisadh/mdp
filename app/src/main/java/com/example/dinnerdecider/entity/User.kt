package com.example.dinnerdecider.entity

data class User(private val firstName: String, private val lastName: String, private val username: String, private val password: String) {
    override fun equals(other: Any?): Boolean {
        val user = other as User
        if (this.username == user.username && this.password == user.password) return true
        return false
    }
}