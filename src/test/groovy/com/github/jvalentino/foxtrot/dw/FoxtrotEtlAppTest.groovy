package com.github.jvalentino.foxtrot.dw

import org.springframework.boot.SpringApplication
import spock.lang.Specification

class FoxtrotEtlAppTest extends Specification {

    def setup() {
        GroovyMock(SpringApplication, global:true)
    }

    def "test main"() {
        when:
        FoxtrotEtlApp.main(null)

        then:
        1 * SpringApplication.run(FoxtrotEtlApp, null)
    }

}
