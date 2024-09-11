package com.agvber.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PhotoPagingSource<T : Any>(
    private val function: suspend (params: LoadParams<Int>) -> List<T>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: 1
        return try {
            LoadResult.Page(
                data = function(params),
                prevKey = if (page == 1) null else page - 1,
                nextKey = page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}