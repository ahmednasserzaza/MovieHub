package com.fighter.moviehub.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fighter.moviehub.data.model.Movie
import com.fighter.moviehub.data.model.PopularMoviesResponse
import com.fighter.moviehub.data.repositories.MovieRepository
import com.fighter.moviehub.ui.base.BaseViewModel
import com.fighter.moviehub.utils.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : BaseViewModel() , MovieInteractionListener {
    override val tag: String = this::class.java.simpleName
    private val repository = MovieRepository()

    private val _popularMovies = MutableLiveData<State<PopularMoviesResponse?>>()
    val popularMovies: LiveData<State<PopularMoviesResponse?>> = _popularMovies

    init {
        getAllPopularMovies()
    }
    private fun getAllPopularMovies() {
        repository.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::fetchPopularMovies, ::onError)
            .addToCompositeDisposable()
    }

    private fun fetchPopularMovies(state: State<PopularMoviesResponse?>) {
        _popularMovies.postValue(state)
    }

    private fun onError(throwable: Throwable) {
        log(throwable.message.toString())
    }

    override fun onClickMovie(movie: Movie) {
        log(movie.title.toString())
    }

}