package com.sample.myapplication.ui.main.tasks.task2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.domain.model.Planet
import com.sample.myapplication.databinding.ItemPlanetBinding

class PlanetsAdapter(
    val viewModel: Task2ViewModel,
    arrayList: List<Planet>
) : RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

    private var planets = mutableListOf<Planet>()

    init {
        planets.addAll(arrayList)
    }

    fun addPlanets(planet: List<Planet>) {
        planets.clear()
        planets.addAll(planet)
        notifyDataSetChanged()
    }

    fun addPlanet(planet: Planet) {
        planets.add(planet)
        notifyItemInserted(planets.indexOf(planet))
    }

    fun removePlanet(planet: Planet) {
        notifyItemRemoved(planets.indexOf(planet))
        planets.remove(planet)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlanetsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlanetBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetsAdapter.ViewHolder, position: Int) {
        holder.bind(planets[position])
    }

    override fun getItemCount(): Int {
        return planets.size
    }

    inner class ViewHolder(private val binding: ItemPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {
            binding.planet.text = planet.name
            binding.population.text = planet.population
            binding.climate.text = planet.climate
        }
    }
}