package com.alidevs.loginregisterprofile.model

import java.io.Serializable

data class UserModel(
    var email: String,
    var id: String,
    var password: String,
    var photo: String,
    var username: String
) : Serializable