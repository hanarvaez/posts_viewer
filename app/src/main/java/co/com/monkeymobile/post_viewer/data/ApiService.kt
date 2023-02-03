package co.com.monkeymobile.post_viewer.data

import co.com.monkeymobile.post_viewer.data.source.remote.response.PostBackendResponse
import co.com.monkeymobile.post_viewer.data.source.remote.response.UserBackendResponse
import retrofit2.http.GET
import retrofit2.http.Path

object ApiUrl {
    const val REST_BASE_URL = "https://jsonplaceholder.typicode.com/"

    const val POST_PARTICLE = "posts/"
    const val USERS_PARTICLE = "users/"
}

interface ApiService {

    @GET(ApiUrl.POST_PARTICLE)
    suspend fun fetchPostsList(): List<PostBackendResponse>

    @GET("${ApiUrl.POST_PARTICLE}{postId}")
    suspend fun fetchPost(@Path("postId") postId: Int): PostBackendResponse

    @GET("${ApiUrl.USERS_PARTICLE}{userId}")
    suspend fun fetchUser(@Path("userId") userId: Int): UserBackendResponse
}