package com.udit.shangri_la.data.repository.movies.executor

import com.udit.shangri_la.core.executor.ThreadExecutor
import java.util.concurrent.*
import javax.inject.Inject
import javax.inject.Singleton

/**
* Created by Udit on 28/11/17.
*/
@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val workQueue: BlockingQueue<Runnable>
    private val threadPoolExecutor: ThreadPoolExecutor
    private val threadFactory: ThreadFactory

    init {
        workQueue = LinkedBlockingQueue<Runnable>()
        threadFactory = JobThreadFactory()
        threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT,
                this.workQueue, this.threadFactory)
    }

    private class JobThreadFactory : ThreadFactory {

        private var counter = 0

        override fun newThread(runnable: Runnable?): Thread =
                Thread(runnable, THREAD_NAME + counter++)

        companion object {
            private val THREAD_NAME = "android_"
        }

    }

    override fun execute(runnable: Runnable?) {
        if (runnable == null) {
            throw IllegalArgumentException("Runnable to execute cannot be null")
        }
        this.threadPoolExecutor.execute(runnable)
    }

    companion object {

        private val INITIAL_POOL_SIZE = 3
        private val MAX_POOL_SIZE = 5

        // Sets the amount of time an idle thread waits before terminating
        private val KEEP_ALIVE_TIME = 10

        // Sets the Time Unit to seconds
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }

}