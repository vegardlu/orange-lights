package lundeberg.tech.orange.lights

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


/**
 *     "event": {
"type": "message",
"channel": "G024BE91L",
"user": "U2147483697",
"text": "One cannot programmatically detect the difference between `message.mpim` and `message.groups`.",
"ts": "1355517523.000005",
"event_ts": "1355517523.000005",
"channel_type": "group"
},
 */