package me.choicore.demo.springmodulith.notification

import me.choicore.demo.springmodulith.Slf4j
import me.choicore.demo.springmodulith.notification.entity.Notification
import org.springframework.modulith.ApplicationModuleListener
import org.springframework.stereotype.Service

@Service
class NotificationManagementService {

    private val logger = Slf4j

    @ApplicationModuleListener
    fun notifyEventListener(notification: Notification) {
        logger.info("[Received] order creation completed notification event => \n$notification")

        Thread.sleep(1000)

        logger.info("[completed] order creation completed")
    }
}