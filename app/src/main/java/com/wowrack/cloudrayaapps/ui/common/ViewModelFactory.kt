package com.wowrack.cloudrayaapps.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wowrack.cloudrayaapps.data.di.Injection
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.ui.screen.home.HomeViewModel
import com.wowrack.cloudrayaapps.ui.screen.login.LoginViewModel
import com.wowrack.cloudrayaapps.ui.screen.monitor.MonitorViewModel
import com.wowrack.cloudrayaapps.ui.screen.profile.ProfileViewModel
import com.wowrack.cloudrayaapps.ui.screen.resource.ResourceViewModel
import com.wowrack.cloudrayaapps.ui.screen.server.ServerViewModel
import com.wowrack.cloudrayaapps.ui.screen.welcome.WelcomeViewModel

class ViewModelFactory(
    private val userRepository: UserRepository,
    private val serverRepository: ServerRepository,
    private val articleRepository: ArticleRepository
) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(WelcomeViewModel::class.java) ->
                WelcomeViewModel(userRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(userRepository, articleRepository) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(userRepository) as T
            modelClass.isAssignableFrom(MonitorViewModel::class.java) ->
                MonitorViewModel(serverRepository) as T
            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->
                ProfileViewModel(userRepository) as T
            modelClass.isAssignableFrom(ResourceViewModel::class.java) ->
                ResourceViewModel(serverRepository) as T
            modelClass.isAssignableFrom(ServerViewModel::class.java) ->
                ServerViewModel(serverRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}

fun getViewModelFactory(context: Context): ViewModelFactory {
    return ViewModelFactory(
        Injection.provideUserRepository(context),
        Injection.provideServerRepository(context),
        Injection.provideArticleRepository()
    )
}