package com.wowrack.cloudrayaapps.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.SubscribeNotificationRequest
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.token.DeviceTokenManager
import com.wowrack.cloudrayaapps.data.utils.getTokenAndValidate
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FirebaseRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
    private val validateLogin: suspend () -> Boolean,
) {

    @OptIn(DelicateCoroutinesApi::class)
    fun subscribeNotification(): LiveData<Result<Boolean>> = liveData(Dispatchers.IO) {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            GlobalScope.launch {
                if (task.isSuccessful) {

                    val fcmToken = task.result
                    val userToken =
                        getTokenAndValidate(userPreference, validateLogin)

                    if (userToken == null) {
                        emit(Result.Error("User not logged in"))
                        return@launch
                    }

                    val response = apiService.subscribeNotification(
                        userToken,
                        SubscribeNotificationRequest(
                            fcmToken,
                            DeviceTokenManager.getDeviceToken()
                        ),
                    )
                    emit(Result.Success(response.isSuccessful))
                } else {
                    emit(Result.Error("Failed to get FCM token"))
                }
            }
        }
    }

    companion object {
        @Volatile
        private var instance: FirebaseRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
            validateLogin: suspend () -> Boolean
        ): FirebaseRepository =
            instance ?: synchronized(this) {
                instance ?: FirebaseRepository(
                    apiService,
                    userPreference,
                    validateLogin
                )
            }.also { instance = it }
    }
}