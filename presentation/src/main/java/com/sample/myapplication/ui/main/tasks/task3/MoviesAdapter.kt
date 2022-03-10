package com.sample.myapplication.ui.main.tasks.task3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.data.core.Constants
import com.sample.data.core.extension.format
import com.sample.domain.model.Movie
import com.sample.myapplication.databinding.ItemFilmBinding

class MoviesAdapter(
    val viewModel: Task3ViewModel,
    arrayList: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var movies = mutableListOf<Movie>()

    init {
        movies.addAll(arrayList)
    }

    fun addMovies(planet: List<Movie>) {
        movies.clear()
        movies.addAll(planet)
        notifyDataSetChanged()
    }

    fun addMovie(planet: Movie) {
        movies.add(planet)
        notifyItemInserted(movies.indexOf(planet))
    }

    fun removeMovie(planet: Movie) {
        notifyItemRemoved(movies.indexOf(planet))
        movies.remove(planet)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MoviesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.film.text = movie.title
            binding.crawl.text = movie.openingCrawl
            binding.releaseDate.text =
                movie.releaseDate?.format(Constants.DATE_PATTERN_DEFAULT) ?: "Not available"
        }
    }
}