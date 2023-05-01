package com.fighter.moviehub.networking

import com.fighter.moviehub.data.model.PopularMoviesResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Observable<Response<PopularMoviesResponse>>
}