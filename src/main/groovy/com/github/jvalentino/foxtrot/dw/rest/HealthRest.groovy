package com.github.jvalentino.foxtrot.dw.rest

import com.github.jvalentino.foxtrot.dw.dto.HealthDto
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * General endpoint for getting debug info
 */
@CompileDynamic
@RestController
@Slf4j
class HealthRest {

    @GetMapping('/')
    HealthDto health() {
        HealthDto result = new HealthDto()

        result
    }

}
