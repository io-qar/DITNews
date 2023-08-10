package dev.koro.newstesting.controller

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class NewsRequest(
	val context: Context,
	var time: Long = System.currentTimeMillis(),
	private val url: String = "http://cfc-test.ru/mobileproxy/"
) {
	private var text: String = ""

	fun SendRequest(): String {
		val queue = Volley.newRequestQueue(context)
		val stringRequest = StringRequest(Request.Method.GET, url, { response ->
			text = "Response is: ${response.substring(0, 500)}"
		},
		{ text = "That didn't work!" })

		queue.add(stringRequest)
		return text
	}

	fun set(): String {
		return "changeable!"
	}
}