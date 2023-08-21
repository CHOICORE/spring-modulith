package me.choicore.demo.springmodulith

import me.choicore.demo.springmodulith.order.Order
import me.choicore.demo.springmodulith.order.OrderManagementService
import me.choicore.demo.springmodulith.product.Product
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.scheduling.annotation.EnableAsync
import java.util.UUID

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
class SpringModulithApplication

private val logger = LoggerFactory.getLogger(SpringModulithApplication::class.java)

fun main(args: Array<String>) {
    runApplication<SpringModulithApplication>(*args)
        .apply { orderTest(this) }
}

private fun orderTest(configurableApplicationContext: ConfigurableApplicationContext) {

    val orderManagementService: OrderManagementService = configurableApplicationContext.getBean(OrderManagementService::class.java)

    val order = Order(
        id = UUID.randomUUID().toString(),
        product = Product(
            name = "먹태깡",
            amount = 1_700,
            description = "먹태깡",
            quantity = 1
        )
    )

    logger.info("[Started] Order Management Service")
    orderManagementService.order(order)
    logger.info("[Finished] Order Management Service")
}
