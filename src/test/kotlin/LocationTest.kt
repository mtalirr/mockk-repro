import io.mockk.*
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class LocationTest {
    @Test
    fun reproduction() {
        // Section A - Mock the location
        val mockLoc = mockk<Location>()

        // Section B
//        clearAllMocks()
        unmockkAll()

        // Section C - Mock the unimportant class
        val mockUnimportant = mockk<Unimportant>()

        var locations = emptyList<Location>()

        // Create some random objects
        val creationMs = measureTimeMillis {
            locations = (1..50_000_000).map {
                val x = Random.nextDouble(60.0, 80.0)
                val y = Random.nextDouble(100.0, 120.0)

                val loc = Location()
                loc.x = x
                loc.y = y

                loc
            }
        }
        println("Created in $creationMs ms")

        // Run a function on them
        val distanceMs = measureTimeMillis {
            locations.zipWithNext { a, b -> a.distance(b) }
        }

        println("Run in $distanceMs ms")
    }
}