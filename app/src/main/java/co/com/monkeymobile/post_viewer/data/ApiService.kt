package co.com.monkeymobile.post_viewer.data

import co.com.monkeymobile.post_viewer.data.source.remote.response.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

object ApiUrl {
    const val REST_BASE_URL = "https://jsonplaceholder.typicode.com/"

    const val POST_PARTICLE = "posts/"
}

interface ApiService {

    @GET(ApiUrl.POST_PARTICLE)
    suspend fun fetchPostsList(): List<PostResponse>

    @GET("${ApiUrl.POST_PARTICLE}{postId}")
    suspend fun fetchPost(@Path("postId") postId: Int): PostResponse
}