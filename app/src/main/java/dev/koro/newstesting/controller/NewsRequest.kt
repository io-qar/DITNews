package dev.koro.newstesting.controller

import android.content.Context
import androidx.compose.runtime.MutableState
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import dev.koro.newstesting.entity.Author
import dev.koro.newstesting.entity.Category
import dev.koro.newstesting.entity.Comment
import dev.koro.newstesting.entity.Gallery
import dev.koro.newstesting.entity.Like
import dev.koro.newstesting.entity.NewsResponse
import dev.koro.newstesting.entity.Person
import dev.koro.newstesting.entity.View
import org.json.JSONObject


fun sendRequest(ctx: Context, state: MutableState<ArrayList<NewsResponse>>) {
	val queue = Volley.newRequestQueue(ctx)
	val url = "https://cfc.mos.ru/mobileproxy/v6/news"
	val news: ArrayList<NewsResponse> = ArrayList()

	val stringRequest: StringRequest = object: StringRequest(Method.GET, url,
		{ response ->
			val obj = JSONObject(response)
			val newsArrJson = obj.getJSONArray("data") //get news array
			for (i in 0 until newsArrJson.length()) { //through news array
				val newsPiece = newsArrJson.getJSONObject(i) //One news

				val comment = Comment(
					newsPiece.getJSONObject("comments").getBoolean("userComment"),
					newsPiece.getJSONObject("comments").getInt("count")
				)
				val likes = Like(
					newsPiece.getJSONObject("likes").getBoolean("userLike"),
					newsPiece.getJSONObject("likes").getInt("count"),
					newsPiece.getJSONObject("likes").getBoolean("showCount"),
					newsPiece.getJSONObject("likes").getBoolean("enabled")
				)
				val author = Author(
					newsPiece.getJSONObject("author").getString("name"),
					newsPiece.getJSONObject("author").getString("imageURL")
				)
				val category = Category(
					newsPiece.getJSONObject("category").getString("imageURL"),
					newsPiece.getJSONObject("category").getString("name"),
					newsPiece.getJSONObject("category").getString("id")
				)

				val galleryArrJson = newsPiece.getJSONArray("gallery")
				val galleryArray = mutableListOf<Gallery>()
				for (j in 0 until galleryArrJson.length()) {
					val galleryPiece = galleryArrJson.getJSONObject(j)

					val gallery = Gallery(
						galleryPiece.getString("url"),
						galleryPiece.getInt("height"),
						galleryPiece.getInt("width")
					)
					galleryArray.add(gallery)
				}

				val view = View(
					newsPiece.getJSONObject("views").getBoolean("userView"),
					newsPiece.getJSONObject("views").getInt("count"),
				)

				val personsArrJson = newsPiece.getJSONArray("persons")
				val personsArray = mutableListOf<Person>()
				for (j in 0 until personsArrJson.length()) {
					val person = personsArrJson.getJSONObject(j)

					val pers = Person(
						person.getString("imageURL"),
						person.getString("role"),
						person.getString("name"),
						person.getString("id")
					)
					personsArray.add(pers)
				}

				val type = newsPiece.getString("type")
				val text = newsPiece.getString("text")
				val title = newsPiece.getString("title")
				val date = newsPiece.getString("date")
				val id = newsPiece.getString("id")

				news.add(NewsResponse(
					comment, likes, author, category, galleryArray, view, personsArray, type, text, title, date, id
				))
			}
			state.value = news
		},
		{

		}
	) {
		override fun getHeaders(): Map<String, String> {
			val params: MutableMap<String, String> = HashMap()
			params["X-CFC-Authorization"] = "93f8590e-a788-4297-93da-c26b27e76e3a"
			params["X-CFC-UserAgent"] = "DeviceID=16261594-C698-4BA5-B115-0E9AB31AA147;DeviceType=iOS;OsVersion=16.0;AppVersion=4.4 (1114)"
			return params
		}
	}

	queue.add(stringRequest)
}
