package com.example.kinopoiskapi

import android.util.Log
import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResult<T>(
    val data :T? = null,
    val code:Int? = null,
    val exception:Throwable? = null,
    val message:String? = null
) {

    class Success<T>(data:T?):NetworkResult<T>(
        data = data)
    class Error<T>(data:T?, message: String?,code: Int):NetworkResult<T>(
        data = data,
        message = message,
        code = code)
    class Exception<T>(exception: Throwable?):NetworkResult<T>(exception = exception)
    class Loading<T>:NetworkResult<T>()

}

fun <T,R> NetworkResult<T>.map(transform:(T)->R):NetworkResult<R>{
    return when(this) {
        is NetworkResult.Success->NetworkResult.Success(transform(data!!))
        is NetworkResult.Error->NetworkResult.Error(data = null,message = message,code= code!!)
        is NetworkResult.Exception->NetworkResult.Exception(exception = exception)

        else -> {
            NetworkResult.Loading()
        }
    }


}

suspend fun <T>safeResponse(response: suspend()->Response<T>):NetworkResult<T>{

   return try {

        val response = response()
        if (response.isSuccessful){

            val body = response.body()
            NetworkResult.Success(data = body)

        }else{
            NetworkResult.Error(data = null, message = response.message(), code = response.code())
        }


    }catch (e:HttpException){
            NetworkResult.Error(data = null, code = e.code(), message = e.message)

    }catch (e:Throwable){
        NetworkResult.Exception(exception = e)
    }

}