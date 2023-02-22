package com.github.jvalentino.foxtrot.dw.repo

import com.github.jvalentino.foxtrot.dw.entity.DocDw
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for the Doc entity
 * @author john.valentino
 */
interface DocRepoDw extends JpaRepository<DocDw, Long> {

}
