package com.example.kinopoiskapi.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kinopoiskapi.data.api.ApiService
import com.example.kinopoiskapi.data.model.MovieDto
import java.lang.Exception

import javax.inject.Inject

class MoviePagingDataSource @Inject constructor(
    private val apiService: ApiService
): PagingSource<Int, MovieDto>() {
    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
       return try {

           val page = params.key ?: 1
           val limit = 10
           val response = listOf(apiService.getMovie(page = page, limit = limit).body()!!)
           val nextKey = if(response.isEmpty()) null else response.size.plus(page).plus(1)
           val prevKey = if(page == 1) null else response.size.minus(limit)
           LoadResult.Page(
               data = response,
               nextKey= nextKey,
               prevKey = prevKey
           )

        }catch (e:Exception){
            return LoadResult.Error(e)
        }
    }
}