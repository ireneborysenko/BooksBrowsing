package com.borysenko.booksbrowsing.dagger

import com.borysenko.booksbrowsing.network.BASE_URL
import com.borysenko.booksbrowsing.network.BooksApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.borysenko.booksbrowsing.model.Book
import com.google.gson.GsonBuilder

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 25/03/19
 * Time: 20:32
 */
@Module
@Suppress("unused")
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Book::class.java, BookDeserializer())
            .create()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideBooksApi(retrofit: Retrofit): BooksApi {
        return retrofit.create(BooksApi::class.java)
    }
}