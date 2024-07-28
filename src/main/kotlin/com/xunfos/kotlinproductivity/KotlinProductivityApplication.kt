package com.xunfos.kotlinproductivity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinProductivityApplication

fun main(args: Array<String>) {
    runApplication<KotlinProductivityApplication>(*args)
}

@RestController
@RequestMapping("/poke")
class ApiController(private val pokeRepository: PokeRepository) {

    @GetMapping
    fun list(): List<Pokemon> = pokeRepository.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Pokemon> =
        pokeRepository.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping(consumes = ["application/json"])
    fun save(@RequestBody pokemon: Pokemon): Pokemon = pokeRepository.save(pokemon)
}

data class Pokemon(val id: Int, val name: String, val mainType: String, val subType: String? = null)

@Component
class PokeRepository {
    private val repo = mutableMapOf<Int, Pokemon>()

    fun getAll(): List<Pokemon> = repo.values.toList()
    fun getById(id: Int): Pokemon? = repo[id]
    final fun save(pokemon: Pokemon): Pokemon = repo.put(pokemon.id, pokemon) ?: pokemon

    init {
        save(Pokemon(id = 25, name = "Pikachu", mainType = "Electric"))
        save(Pokemon(id = 272, name = "Ludicolo", mainType = "Water", subType = "Grass"))
    }
}