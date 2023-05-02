package com.fighter.moviehub.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fighter.moviehub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.recyclerMovie.adapter = adapter

        onClickMovie()
    }

    private fun onClickMovie() {
        viewModel.movieData.observe(this) { movie ->
            Toast.makeText(this, "${movie.title}", Toast.LENGTH_SHORT).show()
        }
    }
}