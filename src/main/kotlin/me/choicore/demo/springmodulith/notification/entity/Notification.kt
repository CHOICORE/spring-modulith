package me.choicore.demo.springmodulith.notification.entity

import me.choicore.demo.springmodulith.Validator
import java.time.Instant

data class Notification(
    val type: NotificationType,
    val subject: String? = null,
    val message: String,
    val notifiedAt: String? = Instant.now().toString(),
) : Validator {
    override fun validate() {
        if (message.isBlank()) {
            throw IllegalArgumentException("Message cannot be blank")
        }
    }
}