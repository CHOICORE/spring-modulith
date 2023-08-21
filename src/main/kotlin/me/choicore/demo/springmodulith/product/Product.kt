package me.choicore.demo.springmodulith.product

import me.choicore.demo.springmodulith.Validator
import java.util.UUID

data class Product(
    val id: String? = UUID.randomUUID().toString(),
    val name: String,
    val amount: Int,
    val description: String,
    val quantity: Int,
) : Validator {

    override fun validate() {
        require(name.isNotBlank()) { "Product name must not be blank" }
    }

}