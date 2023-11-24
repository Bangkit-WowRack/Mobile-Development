package com.wowrack.cloudrayaapps.data.utils

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.ErrorResponse
import com.wowrack.cloudrayaapps.data.model.Key
import com.wowrack.cloudrayaapps.data.model.LoginRequest
import com.wowrack.cloudrayaapps.data.model.LoginResponse
import com.wowrack.cloudrayaapps.data.pref.KeyPreference
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.token.getUserToken
import com.wowrack.cloudrayaapps.data.token.isTokenExpired
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class UserNotLoggedInException : Exception("User Not Logged In")

//suspend fun apiCallWithAuth(
//    userPreference: UserPreference,
//    apiCall: suspend (String) -> Unit
//) {
//    if (userPreference.getUserToken() == null) {
//        throw UserNotLoggedInException()
//    }
//    val token = userPreference.getUserToken() ?: throw UserNotLoggedInException()
//    apiCall(token)
//}

suspend fun getTokenAndValidate(
    userPreference: UserPreference,
    validateLogin: suspend () -> Boolean,
): String? {
    val token = userPreference.getUserToken()
    if (token != null) {
        if (userPreference.isTokenExpired()) {
            val isValid = validateLogin()
            return if (isValid) {
                userPreference.getUserToken()
            } else {
                null
            }
        }
        return token
    }

    return null
}

//suspend fun errorHandler(
//    e: Exception,
//    userPreference: UserPreference,
//    apiCall: suspend (String) -> Unit,
//    validateLogin: suspend () -> Unit,
//): Result<Nothing>? {
//    when (e) {
//        is UserNotLoggedInException -> {
//            validateLogin()
//            val token = userPreference.getUserToken() ?: return Result.NotLogged
//            apiCall(token)
//        }
//        else -> {
//            return Result.Error(e.message.toString())
//        }
//    }
//}