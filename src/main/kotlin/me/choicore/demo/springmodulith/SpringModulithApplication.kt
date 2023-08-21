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

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
class SpringModulithApplication

private val logger = LoggerFactory.getLogger(SpringModulithApplication::class.java)

fun main(args: Array<String>) {
    val runApplication = runApplication<SpringModulithApplication>(*args)
//    testOrder(runApplication)
}


private fun testOrder(runApplication: ConfigurableApplicationContext) {
    val orderManagementService: OrderManagementService = runApplication.getBean(OrderManagementService::class.java)
    val product: Product = validate { Product(name = "1", amount = 1, description = "1", quantity = 1) }
    logger.info("Started Order Management Service")
    orderManagementService.order(Order(product = product))
    logger.info("Finished Order Management Service")
}
