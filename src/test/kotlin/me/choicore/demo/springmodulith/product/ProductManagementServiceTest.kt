package me.choicore.demo.springmodulith.product

import org.junit.jupiter.api.Test
import org.springframework.modulith.test.ApplicationModuleTest


@ApplicationModuleTest
class ProductManagementServiceTest(
    private val productManagementService: ProductManagementService,
) {

    @Test
    fun `product registration success case`() {
        productManagementService.register(Product(name = "1", amount = 1, description = "1", quantity = 1))
    }

}