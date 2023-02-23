package com.github.jvalentino.foxtrot.dw.service

import com.github.jvalentino.foxtrot.dw.entity.BatchRun
import com.github.jvalentino.foxtrot.dw.repo.BatchRunRepo
import com.github.jvalentino.foxtrot.dw.util.DateGenerator
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import java.sql.Timestamp

/**
 * Runs on a schedule
 */
@Service
@CompileDynamic
@Slf4j
class BatchService {

    @Autowired
    BatchRunRepo batchRunRepo

    @Scheduled(fixedRate = 60000L)
    void scheduled() {
        log.info('RUNNING ON SCHEDULE')

        Date startDate = DateGenerator.date()

        Date endDate = DateGenerator.date()
        BatchRun run = new BatchRun()
        run.with {
            success = true
            errorText = null
            runtimeMs = endDate.time - startDate.time
            createdDateTime = new Timestamp(startDate.time)
        }
        batchRunRepo.save(run)
    }

}
