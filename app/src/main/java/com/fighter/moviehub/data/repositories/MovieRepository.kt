package com.fighter.moviehub.data.repositories

import com.fighter.moviehub.BuildConfig
import com.fighter.moviehub.data.model.PopularMoviesResponse
import com.fighter.moviehub.networking.API
import com.fighter.moviehub.utils.State
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MovieRepository {
    fun getPopularMovies(): Single<State<PopularMoviesResponse?>> {
        return wrapWithObservable(API.movieService.getPopularMovies(BuildConfig.API_KEY))
    }

    private fun <T> wrapWithObservable(response: Single<Response<T>>): Single<State<T?>> {
        return response
            .map {
                if (it.isSuccessful) {
                    State.Success(it.body())
                } else {
                    State.Error(it.message())
                }
            }.onErrorReturn { State.Error(it.message.toString()) }
    }
}