package com.github.jvalentino.foxtrot.rest.repo

import com.github.jvalentino.foxtrot.rest.entity.Doc
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for the Doc entity
 * @author john.valentino
 */
interface DocRepo extends JpaRepository<Doc, Long> {

}
