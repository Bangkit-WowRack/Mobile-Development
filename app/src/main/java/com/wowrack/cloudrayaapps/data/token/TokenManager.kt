package com.wowrack.cloudrayaapps.data.token

import com.wowrack.cloudrayaapps.data.pref.UserPreference
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

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

suspend fun UserPreference.isTokenExpired(): Boolean {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")

    return try {
        val expiredDate = getExpiredAt().first() ?: return true
        val expiredDateFormat = dateFormat.parse(expiredDate)
        val currentDate = Date()

        currentDate.after(expiredDateFormat)
    } catch (e: Exception) {
        true
    }
}