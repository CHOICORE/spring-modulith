package me.choicore.demo.springmodulith.notification

import me.choicore.demo.springmodulith.Slf4j
import me.choicore.demo.springmodulith.Validator
import org.springframework.modulith.ApplicationModuleListener
import org.springframework.stereotype.Service
import java.time.Instant

@Service
internal class NotificationManagementService {

    private val logger = Slf4j

    @ApplicationModuleListener
    fun notifyEventListener(notification: Notification) {
        logger.info("[received] order creation completed notification event => \n$notification")

        Thread.sleep(1000)

        logger.info("[completed] order creation completed")
    }
}

internal data class Notification(
    val type: NotificationType,
    val message: String,
    val notifiedAt: String? = Instant.now().toString(),
) : Validator {
    override fun validate() {
        if (message.isBlank()) {
            throw IllegalArgumentException("Message cannot be blank")
        }
    }
}

internal enum class NotificationType {
    EMAIL,
    SMS,
    PUSH,
}