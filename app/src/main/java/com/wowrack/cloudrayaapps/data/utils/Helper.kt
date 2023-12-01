package com.wowrack.cloudrayaapps.data.utils

import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.token.getUserToken
import com.wowrack.cloudrayaapps.data.token.isTokenExpired

suspend fun getTokenAndValidate(
    userPreference: UserPreference,
    validateLogin: suspend () -> Boolean,
): String? {
    val token = userPreference.getUserToken()

    if (token != null && !userPreference.isTokenExpired()) {
        return token
    }

    return if (validateLogin()) userPreference.getUserToken() else null
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