
import com.xunfos.kotlinproductivity.PokeRepository
import com.xunfos.kotlinproductivity.Pokemon

val pokeRepository = PokeRepository()

pokeRepository.save(Pokemon(1, "Bulbasaur", "Grass"))
pokeRepository.save(Pokemon(2, "Venosaur", "Grass"))

pokeRepository.getAll()

pokeRepository.getById(2)
