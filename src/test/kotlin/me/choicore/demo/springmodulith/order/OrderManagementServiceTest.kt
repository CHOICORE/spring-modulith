package me.choicore.demo.springmodulith.order

import me.choicore.demo.springmodulith.product.Product
import me.choicore.demo.springmodulith.validate
import org.junit.jupiter.api.Test
import org.springframework.modulith.events.core.EventPublicationRegistry
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.Scenario

@ApplicationModuleTest
class OrderManagementServiceTest(
    private val orderManagementService: OrderManagementService,
    private val eventPublicationRegistry: EventPublicationRegistry,
) {
    @Test
    fun `order creation success case`() {
        val product: Product = validate { Product(name = "1", amount = 1, description = "1", quantity = 1) }
        orderManagementService.order(Order(product = product))
    }


    @Test
    fun `publishes order completion`(scenario: Scenario) {
        val product: Product = validate { Product(name = "1", amount = 1, description = "1", quantity = 1) }
        val order = Order(product = product)

        scenario.stimulate(Runnable { orderManagementService.order(order) })
            .andWaitForStateChange {
                eventPublicationRegistry.findIncompletePublications().isEmpty()
            }
            .andExpect(Product::class.java)
            .toArrive()
    }
}