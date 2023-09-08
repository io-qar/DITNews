package dev.koro.newstesting.view

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.koro.newstesting.controller.sendRequest
import dev.koro.newstesting.entity.NewsResponse

@Composable
fun News(stateNews: MutableState<ArrayList<NewsResponse>>) {
	LazyColumn(Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp)) {
		items(stateNews.value) {news ->
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

@Composable
fun SendRequestButton(ctx: Context, stateNews: MutableState<ArrayList<NewsResponse>>, statePageLim: String) {
	ExtendedFloatingActionButton(
		{ sendRequest(ctx, stateNews, statePageLim) },
		Modifier.padding(all = 16.dp),
		content = {Text("Send a request")}
	)
}