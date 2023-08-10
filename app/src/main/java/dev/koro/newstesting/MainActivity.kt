package dev.koro.newstesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.koro.newstesting.controller.NewsRequest
import dev.koro.newstesting.ui.theme.NewsTestingTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			NewsTestingTheme {
				val newsRequest = NewsRequest(this)
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					var text = remember {
						mutableStateOf("")
					}
					Basics(text, newsRequest)
				}
			}
		}
	}
}

@Composable
fun Basics(t: MutableState<String>, r: NewsRequest) {
	Column(
		Modifier.fillMaxSize(),
		Arrangement.Center,
		Alignment.CenterHorizontally
	) {
		Text(text = t.value)
		Button(onClick = {
			t.value = r.SendRequest()
		}) {
			Text(text = "Send a news request")
		}
	}
}