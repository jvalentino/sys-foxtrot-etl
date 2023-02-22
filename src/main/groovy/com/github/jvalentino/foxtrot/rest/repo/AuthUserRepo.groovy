package com.github.jvalentino.foxtrot.rest.repo

import com.github.jvalentino.foxtrot.rest.entity.AuthUser
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for the AuthUser entity
 * @author john.valentino
 */
interface AuthUserRepo extends JpaRepository<AuthUser, Long> {

}
