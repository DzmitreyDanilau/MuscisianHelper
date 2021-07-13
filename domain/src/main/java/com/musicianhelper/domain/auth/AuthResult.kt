package com.musicianhelper.domain.auth

import com.musicianhelper.data.user.UserModel
import com.musicianhelper.domain.base.Result

sealed class AuthResult  {

    data class Success(val user: UserModel?) : AuthResult()
    class Failed(val error: String? = null) : AuthResult()

}