package com.udit.shangri_la.core

import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import rx.Observable
import rx.Single
import rx.Subscriber
import rx.functions.Action1
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
* Created by Udit on 21/10/17.
*/
abstract class BaseUseCase<R, T> protected constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    private var subscription = Subscriptions.empty()

    /**
     * Builds an [Observable] which will be used when executing the current [BaseUseCase].
     */
    protected abstract fun buildUseCaseObservable(input: R): Single<T>

    /**
     * Executes the current use case.
     * @param useCaseSubscriber The guy who will be listen to the observable build with [ ][.buildUseCaseObservable].
     */
    @SuppressWarnings("unchecked")
    fun execute(input: R, useCaseSubscriber: Subscriber<T>) {
        this.subscription = this.buildUseCaseObservable(input)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(useCaseSubscriber)
    }

    @SuppressWarnings("unchecked")
    fun execute(input: R, onSuccess: Action1<T>, onError: Action1<Throwable>) {
        this.subscription = this.buildUseCaseObservable(input)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(onSuccess, onError)
    }


    /**
     * Unsubscribes from current Subscription.
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

}