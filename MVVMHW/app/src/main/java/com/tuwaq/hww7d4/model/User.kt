package com.tuwaq.hww7d4.model
import java.io.Serializable
data class User (
    val email: String,
    val id: String,
    val password: String,
    val photo: String,
    val username: String
):Serializable