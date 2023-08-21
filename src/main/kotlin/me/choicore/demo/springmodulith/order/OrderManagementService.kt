package me.choicore.demo.springmodulith.order

import me.choicore.demo.springmodulith.Slf4j
import me.choicore.demo.springmodulith.notification.entity.Notification
import me.choicore.demo.springmodulith.notification.entity.NotificationType
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
        logger.info("Order creation => \n$order")
        validate { order }

        val product = validate { order.product }

        applicationEventPublisher.publishEvent(product)
        logger.info("[Published] product registration event")

        val notification: Notification = validate {
            Notification(
                type = NotificationType.PUSH,
                subject = "상품 주문이 완료되었습니다.",
                message = "$order",
            )
        }

        applicationEventPublisher.publishEvent(notification)
        logger.info("[Published] order creation completed notification event")
    }
}