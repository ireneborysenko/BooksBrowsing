package com.borysenko.booksbrowsing.dagger.component

import com.borysenko.booksbrowsing.dagger.NetworkModule
import com.borysenko.booksbrowsing.viewmodel.BookListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 26/03/19
 * Time: 20:05
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelComponent {

    fun inject(bookListViewModel: BookListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelComponent

        fun networkModule(networkModule: NetworkModule): Builder
    }
}