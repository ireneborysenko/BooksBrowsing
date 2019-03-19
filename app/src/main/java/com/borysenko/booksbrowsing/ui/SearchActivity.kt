package com.borysenko.booksbrowsing.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.borysenko.booksbrowsing.R
import kotlinx.android.synthetic.main.activity_search.*

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 19/03/19
 * Time: 18:06
 */
class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val actionBar = supportActionBar
        actionBar!!.title = "Search Books"

        go_search_button.setOnClickListener{
            val tit = title_edit.text.toString()
            val auth = author_edit.text.toString()
            it.hideKeyboard()
            title_edit.clearFocus()
            author_edit.clearFocus()
        }
    }
}

private fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
