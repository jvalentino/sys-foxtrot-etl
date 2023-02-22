package com.github.jvalentino.foxtrot.dw.rest

import com.github.jvalentino.foxtrot.dw.dto.HealthDto
import com.github.jvalentino.foxtrot.dw.repo.AuthUserRepoDw
import com.github.jvalentino.foxtrot.dw.repo.DocRepoDw
import com.github.jvalentino.foxtrot.dw.repo.DocVersionRepoDw
import com.github.jvalentino.foxtrot.rest.repo.AuthUserRepo
import com.github.jvalentino.foxtrot.rest.repo.DocRepo
import com.github.jvalentino.foxtrot.rest.repo.DocVersionRepo
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * General endpoint for getting debug info
 */
@CompileDynamic
@RestController
@Slf4j
class HealthRest {

    @Autowired
    AuthUserRepo authUserRepo

    @Autowired
    DocRepo docRepo

    @Autowired
    DocVersionRepo docVersionRepo

    @Autowired
    AuthUserRepoDw authUserRepoDw

    @Autowired
    DocRepoDw docRepoDw

    @Autowired
    DocVersionRepoDw docVersionRepoDw

    @GetMapping('/')
    HealthDto health() {
        HealthDto result = new HealthDto()
        result.with {
            sourceAuthUsers = authUserRepo.count()
            sourceDocs = docRepo.count()
            sourceDocVersions = docVersionRepo.count()
            destAuthUsers = authUserRepoDw.count()
            destDocs = docRepoDw.count()
            destDocVersions = docVersionRepoDw.count()
        }

        result
    }

}
