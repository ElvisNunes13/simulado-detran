package simulado.example.project.data.repository

import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import simulado.example.project.data.model.Question
import simulado.example.project.generated.resources.Res


class QuizRepository{
    private val json = Json { ignoreUnknownKeys = true }
    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadQuestions(): List<Question> {
        val bytes = Res.readBytes("files/questions.json")
        val text = bytes.decodeToString()
        return json.decodeFromString<List<Question>>(text)
    }
}