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

class ViewModelFactory(
    private val userRepository: UserRepository,
    private val serverRepository: ServerRepository,
    private val articleRepository: ArticleRepository
) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(serverRepository, articleRepository) as T
        } else if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(userRepository) as T
        } else if (modelClass.isAssignableFrom(MonitorViewModel::class.java)) {
            return MonitorViewModel(serverRepository) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(userRepository) as T
        } else if (modelClass.isAssignableFrom(ResourceViewModel::class.java)) {
            return ResourceViewModel(serverRepository) as T
        } else if (modelClass.isAssignableFrom(ServerViewModel::class.java)) {
            return ServerViewModel(serverRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}

fun getViewModelFactory(context: Context): ViewModelFactory {
    return ViewModelFactory(
        Injection.provideUserRepository(context),
        Injection.provideServerRepository(context),
        Injection.provideArticleRepository()
    )
}