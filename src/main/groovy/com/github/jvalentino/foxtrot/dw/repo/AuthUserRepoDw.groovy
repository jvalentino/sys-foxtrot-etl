package com.github.jvalentino.foxtrot.dw.repo

import com.github.jvalentino.foxtrot.dw.entity.AuthUserDw
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Repository interface for the AuthUser entity
 * @author john.valentino
 */
interface AuthUserRepoDw extends PagingAndSortingRepository<AuthUserDw, Long> {

}
