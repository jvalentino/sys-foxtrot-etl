package com.github.jvalentino.foxtrot.dw.repo

import com.github.jvalentino.foxtrot.dw.entity.BatchRun
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Repository interface for the BatchRun entity
 * @author john.valentino
 */
interface BatchRunRepo extends PagingAndSortingRepository<BatchRun, Long> {

}
