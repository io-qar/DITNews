package dev.koro.newstesting.entity

data class JsonResponse(
	val isError: Boolean = false,
	var data: MutableList<NewsResponse>
)