package com.github.jvalentino.foxtrot.rest.repo

import com.github.jvalentino.foxtrot.rest.entity.AuthUser
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Repository interface for the AuthUser entity
 * @author john.valentino
 */
interface AuthUserRepo extends PagingAndSortingRepository<AuthUser, Long> {

}
