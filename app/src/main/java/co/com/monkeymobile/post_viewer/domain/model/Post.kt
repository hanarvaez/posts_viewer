package co.com.monkeymobile.post_viewer.domain.model

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
    val isFavorite: Boolean = false
)