package me.choicore.demo.springmodulith

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import java.util.function.Consumer


class ModularityTests {

    private val applicationModules: ApplicationModules = ApplicationModules.of(SpringModulithApplication::class.java)


    @Test
    @DisplayName("모듈 간 의존성을 검증한다.")
    fun `verify modules`() {
        applicationModules.verify()
    }

    @Test
    @DisplayName("모듈 구조를 출력한다.")
    fun `displaying module structure `() {
        applicationModules.forEach(Consumer(::println))
    }

    @Test
    @DisplayName("모듈 문서를 생성한다.")
    fun createModuleDocumentation() {
        Documenter(applicationModules)
            .writeDocumentation()
            .writeIndividualModulesAsPlantUml()

    }
}