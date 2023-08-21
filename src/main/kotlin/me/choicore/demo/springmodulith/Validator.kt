package me.choicore.demo.springmodulith

interface Validator {
    fun validate()
}

inline fun <T : Validator> validate(block: () -> T): T = block().apply { this.validate() }
