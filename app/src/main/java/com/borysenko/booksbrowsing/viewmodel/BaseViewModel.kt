package com.borysenko.booksbrowsing.viewmodel

import android.arch.lifecycle.ViewModel
import com.borysenko.booksbrowsing.dagger.NetworkModule
import com.borysenko.booksbrowsing.dagger.component.DaggerViewModelComponent
import com.borysenko.booksbrowsing.dagger.component.ViewModelComponent

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 25/03/19
 * Time: 19:52
 */
abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelComponent = DaggerViewModelComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is BookListViewModel -> injector.inject(this)
        }
    }
}
