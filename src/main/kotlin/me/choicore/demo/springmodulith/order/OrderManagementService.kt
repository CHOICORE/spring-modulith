package me.choicore.demo.springmodulith.order

import me.choicore.demo.springmodulith.Slf4j
import me.choicore.demo.springmodulith.notification.Notification
import me.choicore.demo.springmodulith.notification.NotificationType
import me.choicore.demo.springmodulith.validate
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class OrderManagementService(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    private val logger = Slf4j

    @Transactional
    fun order(order: Order) {
        logger.info("order creation : $order")
        validate { order }

        val product = validate { order.product }

        applicationEventPublisher.publishEvent(product)
        logger.info("[published] product registration event")

        val notification: Notification = validate {
            Notification(
                type = NotificationType.SMS,
                message = "[SMS] 상품 등록 알림 | $order",
            )
        }

        applicationEventPublisher.publishEvent(notification)
        logger.info("[published] order creation completed notification event")
    }
}