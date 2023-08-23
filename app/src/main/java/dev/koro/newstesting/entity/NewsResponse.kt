package dev.koro.newstesting.entity

data class NewsResponse(
	var comments: Comment,
	var likes: Like,
	var author: Author,
	var category: Category,
	var gallery: MutableList<Gallery>,
	var views: View,
	var persons: MutableList<Person>,
	var type: String = "",
	var text: String = "",
	var title: String = "",
	var date: String = "",
	var id: String = ""
)