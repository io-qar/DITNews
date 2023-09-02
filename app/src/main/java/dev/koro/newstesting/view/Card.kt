package dev.koro.newstesting.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.koro.newstesting.entity.NewsResponse

@Composable
fun CardView(news: NewsResponse) {
	Text("ID:", fontWeight = FontWeight.Bold)
	Text(news.id, Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Title:", fontWeight = FontWeight.Bold)
	Text(news.title, Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Date:", fontWeight = FontWeight.Bold)
	Text(news.date, Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Persons:", fontWeight = FontWeight.Bold)
	Text(news.persons.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Views:", fontWeight = FontWeight.Bold)
	Text(news.views.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Category:", fontWeight = FontWeight.Bold)
	Text(news.category.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Gallery:", fontWeight = FontWeight.Bold)
	Text(news.gallery.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Author:", fontWeight = FontWeight.Bold)
	Text(news.author.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Likes:", fontWeight = FontWeight.Bold)
	Text(news.likes.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Comments:", fontWeight = FontWeight.Bold)
	Text(news.comments.toString(), Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
	Divider()
	Text("Text:", fontWeight = FontWeight.Bold)
	Text(news.text, Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
}