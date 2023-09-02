package dev.koro.newstesting

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.koro.newstesting.controller.sendRequest
import dev.koro.newstesting.entity.Author
import dev.koro.newstesting.entity.Category
import dev.koro.newstesting.entity.Comment
import dev.koro.newstesting.entity.Gallery
import dev.koro.newstesting.entity.Like
import dev.koro.newstesting.entity.NewsResponse
import dev.koro.newstesting.entity.Person
import dev.koro.newstesting.entity.View
import dev.koro.newstesting.ui.theme.NewsTestingTheme
import dev.koro.newstesting.view.CardView

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

@SuppressLint("MutableCollectionMutableState")
@Composable
fun Main(ctx: Context) {
	val state = remember {
		mutableStateOf(arrayListOf(NewsResponse(
			Comment(false, 0),
			Like(false, 0, false, false),
			Author("", ""),
			Category("", "", ""),
			arrayListOf(Gallery("", 0, 0)),
			View(false, 0),
			arrayListOf(Person("", "", "", "")),
			"", ""
		)))
	}

	sendRequest(ctx, state)

	LazyColumn(Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp)) {
		items(state.value) { news ->
			Card(
				shape = RoundedCornerShape(10.dp),
				elevation = CardDefaults.cardElevation(10.dp)
			) {
				CardView(news)
			}
			Spacer(Modifier.height(20.dp))
		}
	}
}
