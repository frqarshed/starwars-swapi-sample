package com.sample.data.core.network

import com.sample.data.core.network.api.*
import com.sdk.starwars.presentation.core.main.StarWarsController
import com.sdk.starwars.presentation.core.model.*

open class NetworkDataSource :
    MoviesApi,
    CharactersApi,
    PlanetApi,
    SpeciesApi,
    StarshipsApi,
    VehiclesApi {

    private val starWarsController = StarWarsController()
    override suspend fun getAllMovies(pageNumber: Int): Response<AllFilms> =
        starWarsController.getAllFilms(pageNumber)

    override suspend fun getMoviesById(movieId: Int): Response<Film> =
        starWarsController.getFilmById(movieId)

    override suspend fun searchMovie(title: String): Response<AllFilms> =
        starWarsController.searchFilmByTitle(title)

    override suspend fun getAllCharacters(pageNumber: Int): Response<AllPeople> =
        starWarsController.getAllPeoples(pageNumber)

    override suspend fun getCharacterById(characterId: Int): Response<People> =
        starWarsController.getPeopleById(characterId)

    override suspend fun searchCharacter(name: String): Response<AllPeople> =
        starWarsController.searchPeopleByName(name)

    override suspend fun getAllPlanets(pageNumber: Int): Response<AllPlanet> =
        starWarsController.getAllPlanets(pageNumber)

    override suspend fun getPlanetById(planetId: Int): Response<Planet> =
        starWarsController.getPlanetById(planetId)

    override suspend fun searchPlanet(name: String): Response<AllPlanet> =
        starWarsController.searchPlanetByName(name)

    override suspend fun getAllSpecies(pageNumber: Int): Response<AllSpecies> =
        starWarsController.getAllSpecies(pageNumber)

    override suspend fun getSpecieById(specieId: Int): Response<Species> =
        starWarsController.getSpeciesById(specieId)

    override suspend fun searchSpecie(name: String): Response<AllSpecies> =
        starWarsController.searchSpeciesByName(name)

    override suspend fun getAllStarships(pageNumber: Int): Response<AllStarships> =
        starWarsController.getAllStarships(pageNumber)


    override suspend fun getStarshipById(starshipId: Int): Response<Starship> =
        starWarsController.getStarshipById(starshipId)


    override suspend fun searchStarship(name: String): Response<AllStarships> =
        starWarsController.searchStarshipByName(name)


    override suspend fun getAllVehicles(pageNumber: Int): Response<AllVehicles> =
        starWarsController.getAllVehicles(pageNumber)


    override suspend fun getVehicleById(vehicleId: Int): Response<Vehicle> =
        starWarsController.getVehiclesById(vehicleId)


    override suspend fun searchVehicle(name: String): Response<AllVehicles> =
        starWarsController.searchVehiclesByName(name)
}
    


