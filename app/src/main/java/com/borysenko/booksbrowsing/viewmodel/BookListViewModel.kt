package com.borysenko.booksbrowsing.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.borysenko.booksbrowsing.network.BooksApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 26/03/19
 * Time: 20:03
 */
class BookListViewModel:BaseViewModel(){
    @Inject
    lateinit var booksApi: BooksApi

    var query = "YvQ_AhkJpBUC"

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()


    init{
        loadPosts(query)
    }

    private fun loadPosts(volumeId: String){
        subscription = booksApi.getBook(volumeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveBookListStart() }
            .doOnTerminate { onRetrieveBookListFinish() }
            .subscribe(
                { onRetrieveBookListSuccess() },
                { onRetrieveBookListError() }
            )
    }

    private fun onRetrieveBookListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveBookListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveBookListSuccess(){

    }

    private fun onRetrieveBookListError(){

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}