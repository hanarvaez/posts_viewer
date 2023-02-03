package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.util.LOG_MESSAGE_ERROR
import co.com.monkeymobile.post_viewer.util.LOG_MESSAGE_SUCCESS

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> String.format(LOG_MESSAGE_SUCCESS, data.toString())
            is Error -> String.format(LOG_MESSAGE_ERROR, exception.toString())
        }
    }
}

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data


object NoParams

object NoResult