package com.fighter.moviehub.ui

import com.fighter.moviehub.R
import com.fighter.moviehub.data.model.Movie
import com.fighter.moviehub.ui.base.BaseAdapter
import com.fighter.moviehub.ui.base.BaseInterActionListener

class MoviesAdapter(items: List<Movie>, listener: MovieInteractionListener) :
    BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_movie
}

interface MovieInteractionListener : BaseInterActionListener {
    fun onClickMovie(movie: Movie)
}