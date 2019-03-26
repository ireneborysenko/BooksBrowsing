package com.borysenko.booksbrowsing.network

import com.borysenko.booksbrowsing.model.Book
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 25/03/19
 * Time: 20:18
 */
interface BooksApi {
    @GET("/volumes/{volumeId}")
    fun getBook(@Path("volumeId") volumeId: String): Observable<List<Book>>
}
