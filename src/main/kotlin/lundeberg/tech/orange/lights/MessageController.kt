package lundeberg.tech.orange.lights

import com.github.kittinunf.fuel.Fuel
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {
    var log: Logger = LoggerFactory.getLogger(MessageController::class.java)

    @PostMapping("/messages")
    fun newMessage(@RequestBody message: Message): Message {
        log.info("Request: $message")
        Fuel.post("https://homeassistant.lundeberg.tech/api/webhook/orange")
            .response { result ->
                log.info("result: $result")
            }
        return message
    }
}

data class Message(
    val type: String? = null,
    val token: String? = null,
    val challenge: String? = null,
    val domain: String = "lundeberg.tech",
    val event: Event? = null
)

data class Event(
    val user: String,
    val text: String,
    val channel: String
)