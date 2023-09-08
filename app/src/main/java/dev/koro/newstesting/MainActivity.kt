package dev.koro.newstesting

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import dev.koro.newstesting.entity.Author
import dev.koro.newstesting.entity.Category
import dev.koro.newstesting.entity.Comment
import dev.koro.newstesting.entity.Gallery
import dev.koro.newstesting.entity.Like
import dev.koro.newstesting.entity.NewsResponse
import dev.koro.newstesting.entity.Person
import dev.koro.newstesting.entity.View
import dev.koro.newstesting.ui.theme.NewsTestingTheme
import dev.koro.newstesting.view.News
import dev.koro.newstesting.view.SendRequestButton

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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("MutableCollectionMutableState")
@Composable
fun Main(ctx: Context) {
	val stateNews = remember {
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
	var statePageLim by remember { mutableStateOf("") }

	Column {
		OutlinedTextField(statePageLim, {statePageLim = it},
			label = {Text("Limit of pages")},
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			singleLine = true
		)

		News(stateNews)
	}

	Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
		SendRequestButton(ctx, stateNews, statePageLim)
	}
}
