package lundeberg.tech.orange.lights

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChallengeController {

    @PostMapping("/challenges")
    fun newChallenge(@RequestBody challenge: Challenge) = challenge
}

data class Challenge(
    val type: String,
    val token: String,
    val challenge: String,
    val domain: String = "lundeberg.tech"
)