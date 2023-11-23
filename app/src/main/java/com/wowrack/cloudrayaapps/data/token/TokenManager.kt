package com.wowrack.cloudrayaapps.data.token

import com.wowrack.cloudrayaapps.data.pref.UserPreference
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first

suspend fun UserPreference.getUserToken(): String? = coroutineScope {
    val token = getToken().first()
    if (token != null) {
        "Bearer $token"
    } else {
        null
    }
}

private fun decodeJwt(token: String): Claims {
    val jws: Jws<Claims> = Jwts.parser().parseClaimsJws(token)
    return jws.body
}

fun isTokenExpired(token: String): Boolean {
    return try {
        val expiration = decodeJwt(token)["exp"] as Long
        val currentTimeMillis = System.currentTimeMillis() / 1000
        currentTimeMillis >= expiration
    } catch (e: Exception) {
        true
    }
}