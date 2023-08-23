package dev.koro.newstesting

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.koro.newstesting.controller.SendRequest
import dev.koro.newstesting.entity.Author
import dev.koro.newstesting.entity.Category
import dev.koro.newstesting.entity.Comment
import dev.koro.newstesting.entity.Gallery
import dev.koro.newstesting.entity.JsonResponse
import dev.koro.newstesting.entity.Like
import dev.koro.newstesting.entity.NewsResponse
import dev.koro.newstesting.entity.Person
import dev.koro.newstesting.entity.View
import dev.koro.newstesting.ui.theme.NewsTestingTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			NewsTestingTheme {
				Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					Main(this)
				}
			}
		}
	}
}

@Composable
fun Main(ctx: Context) {
	val state = remember {
		mutableStateOf(JsonResponse(false, arrayListOf(NewsResponse(
			Comment(false, 0),
			Like(false, 0, false,  false),
			Author("", ""),
			Category("", "", ""),
			arrayListOf(Gallery("", 0, 0)),
			View(false, 0),
			arrayListOf(Person("", "", "", "")),
			"", "")))
		)
	}

	SendRequest(ctx, state)

	LazyColumn(
		Modifier.fillMaxSize(),
	) {
//		if (response is Error) {
//			item {
//				Text(response.toString())
//			}
//		} else {
			items(state.value.data.size) {
				Card(Modifier.fillMaxSize()) {
					Log.i("newsrrar", state.value.data.toString())
				}
			}
//		}
	}
}