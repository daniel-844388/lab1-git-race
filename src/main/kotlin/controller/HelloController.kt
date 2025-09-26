package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalTime

@Controller
class HelloController(
    @param:Value("\${app.message:Hello World}") 
    private val message: String
) {
    
    @GetMapping("/")
    fun welcome(
        model: Model,
        @RequestParam(defaultValue = "") name: String
    ): String {
        val greeting = if (name.isNotBlank()) "Hello, $name!" else message
        model.addAttribute("message", greeting)
        model.addAttribute("name", name)
        return "welcome"
    }
}

/**
 * REST API controller that exposes a simple greeting service.
 *
 * Endpoints:
 * - '/api/hello': Returns a JSON response with a personalized greeting
 *   and a timestamp. The greeting message adapts to the time of day.
 */
@RestController
class HelloApiController {
    
    /**
     * Handles HTTP GET requests to the REST API endpoint '/api/hello'.

     * If param 'name', the greeting is personalized.
     *
     * The greeting changes depending on the current time of day:
     * - Morning (06:00–11:59) → "Good Morning"
     * - Afternoon (12:00–17:59) → "Good Afternoon"
     * - Evening (18:00–23:59) → "Good Evening"
     * - Night (00:00–05:59) → "Good Night"
     *
     * @param name optional name to personalize greeting (default: "World")
     * @return a JSON map with:
     *   - "message" → greeting message
     *   - "timestamp" → current UTC timestamp
     */
    @GetMapping("/api/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloApi(@RequestParam(defaultValue = "World") name: String): Map<String, String> {
        val timeGreeting = getTimeBasedGreeting()
        return mapOf(
            "message" to "$timeGreeting, $name!",
            "timestamp" to java.time.Instant.now().toString()
        )
    }

    /**
     * Determines the appropriate greeting based on the current time of day.
     *
     * @return one of: "Good Morning", "Good Afternoon", "Good Evening", "Good Night"
     */
    private fun getTimeBasedGreeting(): String {
        val now = LocalTime.now()
        return when (now.hour) {
            in 6..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            in 18..23 -> "Good Evening"
            else -> "Good Night"
        }
    }
}
