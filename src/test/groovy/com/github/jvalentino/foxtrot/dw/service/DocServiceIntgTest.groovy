package com.github.jvalentino.foxtrot.dw.service

import com.github.jvalentino.foxtrot.dw.repo.DocRepoDw
import com.github.jvalentino.foxtrot.dw.util.BaseIntg
import com.github.jvalentino.foxtrot.dw.util.DateUtil
import com.github.jvalentino.foxtrot.rest.repo.DocRepo
import org.springframework.beans.factory.annotation.Autowired

class DocServiceIntgTest extends BaseIntg {

    @Autowired
    DocService docService

    @Autowired
    DocRepo docRepo

    @Autowired
    DocRepoDw docRepoDw

    def "Test migrate"() {
        given:
        Date lastRun = DateUtil.toDate('2023-01-02T00:00:00.000+0000')

        when:
        docService.migrate(lastRun, 1)

        then:
        true
    }

}
