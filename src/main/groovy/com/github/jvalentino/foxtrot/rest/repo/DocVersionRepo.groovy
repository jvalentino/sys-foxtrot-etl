package com.github.jvalentino.foxtrot.rest.repo

import com.github.jvalentino.foxtrot.rest.entity.DocVersion
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for the DocVersion entity
 * @author john.valentino
 */
interface DocVersionRepo extends JpaRepository<DocVersion, Long> {

}
