package com.udit.shangri_la.core

import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
* Created by Udit on 21/10/17.
*/
abstract class BaseUseCase<in R, T> protected constructor(private val threadExecutor: ThreadExecutor,
                                                          private val postExecutionThread: PostExecutionThread,
                                                          private val disposables: CompositeDisposable = CompositeDisposable()) {


    /**
     * Builds an [Observable] which will be used when executing the current [BaseUseCase].
     */
    protected abstract fun buildUseCaseObservable(input: R): Single<T>

    /**
     * Executes the current use case.
     * @param observer The guy who will be listen to the observable build with [ ][.buildUseCaseObservable].
     */
    @SuppressWarnings("unchecked")
    fun execute(input: R, observer: SingleObserver<T>) {
        val observable = this.buildUseCaseObservable(input)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        observable.subscribeWith(observer)
    }

//    /**
//     * Dispose from current [CompositeDisposable].
//     */
//    abstract fun dispose()
//
//    /**
//     * Dispose from current [CompositeDisposable].
//     */
//    private fun addDisposable(disposable: Disposable) {
////        Preconditions.checkNotNull(disposable)
////        Preconditions.checkNotNull(disposables)
//        disposables.add(disposable)
//    }
}