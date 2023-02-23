package com.github.jvalentino.foxtrot.dw.service

import com.github.jvalentino.foxtrot.dw.entity.AuthUserDw
import com.github.jvalentino.foxtrot.dw.repo.AuthUserRepoDw
import com.github.jvalentino.foxtrot.dw.util.BaseIntg
import com.github.jvalentino.foxtrot.rest.entity.AuthUser
import com.github.jvalentino.foxtrot.rest.repo.AuthUserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

class UserServiceIntgTest extends BaseIntg {

    @Autowired
    UserService userService

    @Autowired
    AuthUserRepo authUserRepo

    @Autowired
    AuthUserRepoDw authUserRepoDw

    def "test migrate"() {
        given:
        AuthUser unchangedSource = new AuthUser()
        unchangedSource.with {
            authUserId = 1L
            email = 'a'
            password = 'b'
            salt = 'c'
            firstName = 'd'
            lastName = 'e'
        }
        authUserRepo.save(unchangedSource)

        AuthUserDw unchangedDest = new AuthUserDw()
        unchangedDest.with {
            authUserId = 1L
            email = 'a'
            password = 'b'
            salt = 'c'
            firstName = 'd'
            lastName = 'e'
        }
        authUserRepoDw.save(unchangedDest)



        when:
        userService.migrate()

        then:
        true
    }
}
