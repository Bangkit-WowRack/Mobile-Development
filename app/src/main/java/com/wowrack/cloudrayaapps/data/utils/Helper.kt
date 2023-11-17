package com.wowrack.cloudrayaapps.data.utils

import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.token.getUserToken

class UserNotLoggedInException : Exception("User Not Logged In")

suspend fun apiCallWithAuth(
    userPreference: UserPreference,
    apiCall: suspend (String) -> Unit
) {
    val token = userPreference.getUserToken() ?: throw UserNotLoggedInException()
    apiCall(token)
}