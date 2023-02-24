package com.github.jvalentino.foxtrot.dw.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.jvalentino.foxtrot.dw.entity.AuthUserDw
import com.github.jvalentino.foxtrot.dw.repo.AuthUserRepoDw
import com.github.jvalentino.foxtrot.rest.entity.AuthUser
import com.github.jvalentino.foxtrot.rest.repo.AuthUserRepo
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Service for dealing with user related data migration
 * @author john.valentino
 */
@CompileDynamic
@Slf4j
@Service
class UserService {

    @Autowired
    AuthUserRepo authUserRepo

    @Autowired
    AuthUserRepoDw authUserRepoDw

    Map<Long, String> migrate() {
        List<AuthUser> sourceUsers = authUserRepo.findAll()
        List<AuthUserDw> destUsers = authUserRepoDw.findAll()
        Map<Long, AuthUserDw> destUserMap = [:]
        for (AuthUserDw user : destUsers) {
            destUserMap[user.authUserId] = user
        }

        Map<Long, String> results = [:]

        for (AuthUser sourceUser : sourceUsers) {
            AuthUserDw destUser = destUserMap[sourceUser.authUserId]

            boolean isNew = false
            if (destUser == null) {
                destUser = new AuthUserDw()
                isNew = true
            }

            // only save if there has been a change

            String source = new ObjectMapper().writeValueAsString(sourceUser)
            String dest = new ObjectMapper().writeValueAsString(destUser)
            boolean different =  dest != source

            if (different) {
                if (isNew) {
                    results[sourceUser.authUserId] = 'new'
                } else {
                    results[sourceUser.authUserId] = 'updated'
                }
                destUser.with {
                    authUserId = sourceUser.authUserId
                    email = sourceUser.email
                    password = sourceUser.password
                    salt = sourceUser.salt
                    firstName = sourceUser.firstName
                    lastName = sourceUser.lastName
                }

                authUserRepoDw.save(destUser)
            } else {
                results[sourceUser.authUserId] = 'unchanged'
            }

            log.info("AuthUser ${sourceUser.authUserId} ${results[sourceUser.authUserId]}")
        }

        results
    }

}
