import com.jetbrains.workshop.BirdImage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class BirdRepository {
    private val ktorClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    // TODO: Get a list of images from this endpoint: "https://sebi.io/demo-image-api/pictures.json"
    suspend fun getImages(): List<BirdImage> {
        val images = ktorClient.get(URL).body<List<BirdImage>>()
        return images
    }

    fun close() {
        
    }

    companion object {
        private const val URL = "https://sebi.io/demo-image-api/pictures.json"
        val INSTANCE: BirdRepository by lazy {
            BirdRepository()
        }
    }
}