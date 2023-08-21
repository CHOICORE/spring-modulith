package me.choicore.demo.springmodulith.order

import me.choicore.demo.springmodulith.Validator
import me.choicore.demo.springmodulith.product.Product
import java.util.UUID

data class Order(
    val id: String? = UUID.randomUUID().toString(),
    val product: Product,
) : Validator {
    override fun validate() {
        product.validate()
    }
}
