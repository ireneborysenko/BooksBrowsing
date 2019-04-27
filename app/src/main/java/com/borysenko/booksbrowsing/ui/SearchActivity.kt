package com.borysenko.booksbrowsing.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.borysenko.booksbrowsing.R
import com.borysenko.booksbrowsing.databinding.ActivityBookListBinding
import com.borysenko.booksbrowsing.viewmodel.BookListViewModel
import kotlinx.android.synthetic.main.activity_search.*

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 19/03/19
 * Time: 18:06
 */
class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookListBinding
    private lateinit var viewModel: BookListViewModel

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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_list)
        binding.bookList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
        binding.viewModel = viewModel
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
