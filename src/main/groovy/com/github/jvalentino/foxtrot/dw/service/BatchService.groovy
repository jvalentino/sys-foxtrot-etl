package com.github.jvalentino.foxtrot.dw.service

import com.github.jvalentino.foxtrot.dw.entity.BatchRun
import com.github.jvalentino.foxtrot.dw.repo.BatchRunRepo
import com.github.jvalentino.foxtrot.dw.util.DateGenerator
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import java.sql.Timestamp

/**
 * Runs on a schedule
 */
@Service
@CompileDynamic
@Slf4j
@SuppressWarnings(['NoJavaUtilDate'])
class BatchService {

    @Autowired
    BatchRunRepo batchRunRepo

    @Autowired
    UserService userService

    @Autowired
    DocService docService

    @Value('${scheduling.enabled}')
    boolean schedulingEnabled

    @Scheduled(fixedRate = 60000L)
    void scheduled() {
        if (!schedulingEnabled) {
            log.info('SCHEDULING DISABLED')
            return
        }
        log.info('RUNNING ON SCHEDULE')
        Date lastRun = this.lastRunTime

        Date startDate = DateGenerator.date()

        userService.migrate()
        docService.migrate(lastRun)

        // find doc that have not been updated in a year

        Date endDate = DateGenerator.date()

        this.logRun(startDate, endDate)
    }

    protected Date getLastRunTime() {
        List<BatchRun> runs = batchRunRepo.findAll(
                new PageRequest(0, 1, Sort.by('batchRunId').descending())).toList()

        if (runs.size() == 0) {
            log.info('There is no last run time')
            return new Date(0L)
        }

        BatchRun first = runs.first()
        log.info("Last run time was ${first.createdDateTime} as ID ${first.batchRunId}")
        new Date(first.createdDateTime.time)
    }

    protected void logRun(Date startDate, Date endDate) {
        BatchRun run = new BatchRun()
        run.with {
            success = true
            errorText = null
            runtimeMs = endDate.time - startDate.time
            createdDateTime = new Timestamp(endDate.time)
        }
        batchRunRepo.save(run)
    }

}
