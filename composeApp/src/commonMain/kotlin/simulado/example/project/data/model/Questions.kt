package simulado.example.project.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val id: String,
    val parte: Int,
    @SerialName("modulo_numero") val moduloNumber: Int,
    @SerialName("modulo_titulo") val moduloTitle: String,
    val numero: Int,
    val dificuldade: String,
    val enunciado: String,
    @SerialName("codigo_placa") val plateCode: String? = null,
    @SerialName("alternativa_correta") val correctAnswer: String,
    val comentario: String,
    @SerialName("alternativas_incorretas") val wrongAnswers: List<String>,
)

enum class Difficulty(val label: String, val key: String) {
    ALL("Todas", "all"),
    EASY("Fácil", "easy"),
    MEDIUM("Médio", "medium"),
    HARD("Difícil", "hard");

    companion object{
        fun fromKey(key: String) = entries.firstOrNull{ it.key == key } ?: ALL
    }
}