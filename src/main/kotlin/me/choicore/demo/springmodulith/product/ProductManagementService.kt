package me.choicore.demo.springmodulith.product

import me.choicore.demo.springmodulith.Slf4j
import me.choicore.demo.springmodulith.validate
import org.springframework.stereotype.Service


@Service
class ProductManagementService {
    private val logger = Slf4j


    fun register(product: Product) {
        logger.info("[Received] product registration event => \n$product")
        validate { product }
        Thread.sleep(1000)
        logger.info("[completed] product registration event")
    }
}