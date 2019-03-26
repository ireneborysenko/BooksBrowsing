package com.borysenko.booksbrowsing.dagger

import com.borysenko.booksbrowsing.model.Book
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializer
import java.lang.reflect.Type

class BookDeserializer : JsonDeserializer<Book> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext):
            Book {

        val title: String
        val authors: MutableList<String> = mutableListOf()
        val publisher: String
        val pageCount: Int

        val jsonObject = json.asJsonObject
        val volume = jsonObject.get("volumeInfo").asJsonObject
        title = volume.get("title").asString
        publisher = volume.get("publisher").asString
        pageCount = volume.get("pageCount").asInt

        val authorsArray = volume.get("authors").asJsonArray
        for (i in 0..(authorsArray.size() - 1)) {
            val author = authorsArray.get(i)
            authors += author.asString
        }

        return Book(
            title,
            authors,
            publisher,
            pageCount
        )
    }
}
