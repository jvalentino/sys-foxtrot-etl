package com.github.jvalentino.foxtrot.dw

import groovy.transform.CompileDynamic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Main class
 * @author john.valentino
 */
@SpringBootApplication
@CompileDynamic
class FoxtrotEtlApp {

    static void main(String[] args) {
        SpringApplication.run(FoxtrotEtlApp, args)
    }

}
