package com.sample.data.core.network

import com.sample.domain.model.*
import com.sdk.starwars.presentation.core.model.*
import com.sdk.starwars.presentation.core.model.Species
import com.sdk.starwars.presentation.core.model.Starship
import com.sdk.starwars.presentation.core.model.Vehicle
import com.sample.domain.model.Movie as LocalFilm
import com.sample.domain.model.Planet as LocalPlanet
import com.sample.domain.model.Species as LocalSpecies
import com.sample.domain.model.Starship as LocalStarship
import com.sample.domain.model.Vehicle as LocalVehicle

fun AllFilms.toDomain(): Movies = Movies(
    count = count,
    movies = films.toFilmDomain()
)

fun List<Film>.toFilmDomain(): List<LocalFilm> {
    val result = mutableListOf<LocalFilm>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Film.toDomain(): LocalFilm = LocalFilm(
    title = title,
    created = created,
    director = director,
    edited = edited,
    episodeId = episodeId,
    openingCrawl = openingCrawl,
    producer = producer,
    releaseDate = releaseDate,
    charactersIds = charactersIds,
    speciesIds = speciesIds,
    vehiclesIds = vehiclesIds,
    starshipsIds = starshipsIds,
    planetsIds = planetsIds
)

fun AllPeople.toDomain(): Characters = Characters(
    count = count,
    people = people.toPeopleDomain()
)

fun List<People>.toPeopleDomain(): List<Character> {
    val result = mutableListOf<Character>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun People.toDomain(): Character = Character(
    name = name,
    birthYear = birthYear,
    created = created,
    edited = edited,
    eyeColor = eyeColor,
    gender = gender,
    hairColor = hairColor,
    height = height,
    homeWorldId = homeWorldId,
    mass = mass,
    skinColor = skinColor,
    filmsIds = filmsIds,
    speciesIds = speciesIds,
    starshipsIds = starshipsIds,
    vehiclesIds = vehiclesIds
)


fun AllPlanet.toDomain(): Planets = Planets(
    count = count,
    planets = planets.toPlanetDomain()
)

fun List<Planet>.toPlanetDomain(): List<LocalPlanet> {
    val result = mutableListOf<LocalPlanet>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Planet.toDomain(): LocalPlanet = LocalPlanet(
    name = name,
    climate = climate,
    diameter = diameter,
    created = created,
    edited = edited,
    gravity = gravity,
    orbitalPeriod = orbitalPeriod,
    population = population,
    rotationPeriod = rotationPeriod,
    surfaceWater = surfaceWater,
    terrain = terrain,
    filmsIds = filmsIds,
    residentsIds = residentsIds
)


fun AllStarships.toDomain(): Starships = Starships(
    count = count,
    starships = starships.toStarshipDomain()
)

fun List<Starship>.toStarshipDomain(): List<LocalStarship> {
    val result = mutableListOf<LocalStarship>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Starship.toDomain(): LocalStarship = LocalStarship(
    name = name,
    model = model,
    passengers = passengers,
    cargoCapacity = cargoCapacity,
    consumables = consumables,
    costInCredits = costInCredits,
    created = created,
    edited = edited,
    crew = crew,
    hyperDriveRating = hyperDriveRating,
    length = length,
    mGLT = mGLT,
    manufacturer = manufacturer,
    maxAtmospheringSpeed = maxAtmospheringSpeed,
    starshipClass = starshipClass,
    filmsIds = filmsIds,
    pilotsIds = pilotsIds,
)


fun AllSpecies.toDomain(): LocalSpecies = LocalSpecies(
    count = count,
    species = species.toSpeciesDomain()
)

fun List<Species>.toSpeciesDomain(): List<Specie> {
    val result = mutableListOf<Specie>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Species.toDomain(): Specie = Specie(
    name = name,
    averageHeight = averageHeight,
    averageLifespan = averageLifespan,
    classification = classification,
    designation = designation,
    eyeColors = eyeColors,
    hairColors = hairColors,
    language = language,
    skinColors = skinColors,
    homeWorldId = homeWorldId,
    filmsIds = filmsIds,
    peopleIds = peopleIds,
    created = created,
    edited = edited,
)


fun AllVehicles.toDomain(): Vehicles = Vehicles(
    count = count,
    vehicles = vehicles.toVehicleDomain()
)

fun List<Vehicle>.toVehicleDomain(): List<LocalVehicle> {
    val result = mutableListOf<LocalVehicle>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Vehicle.toDomain(): LocalVehicle = LocalVehicle(
    name = name,
    model = model,
    created = created,
    edited = edited,
    cargoCapacity = cargoCapacity,
    consumables = consumables,
    costInCredits = costInCredits,
    crew = crew,
    length = length,
    manufacturer = manufacturer,
    maxAtmosphericSpeed = maxAtmospheringSpeed,
    passengers = passengers,
    vehicleClass = vehicleClass,
    filmsIds = filmsIds,
    pilotsIds = pilotsIds,
)