package com.github.jvalentino.foxtrot.rest.repo

import com.github.jvalentino.foxtrot.rest.entity.DocVersion
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Repository interface for the DocVersion entity
 * @author john.valentino
 */
interface DocVersionRepo extends JpaRepository<DocVersion, Long> {

    @Query('''
        select distinct d from DocVersion d
        where d.createdDateTime >= ?1
    ''')
    Page<DocVersion> findUpdatedAfter(Date date, Pageable pageable)

}
