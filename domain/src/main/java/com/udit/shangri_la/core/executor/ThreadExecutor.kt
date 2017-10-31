package com.udit.shangri_la.core.executor

/**
* Created by Udit on 21/10/17.
*/

import java.util.concurrent.Executor

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the interactor out of the ui thread
 */
interface ThreadExecutor : Executor