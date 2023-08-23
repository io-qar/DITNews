package dev.koro.newstesting.entity

data class Like(
	var userLike: Boolean = false,
	var count: Int = 0,
	var showCount: Boolean = false,
	var enabled: Boolean = false
)