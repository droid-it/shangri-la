package com.udit.shangri_la.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Udit on 01/10/17.
 */
abstract class BasePresenter<T : BaseViewContract> {

    var view: T? = null
    protected val compositeDisposable = CompositeDisposable()

    fun destroy() {
        view = null
        compositeDisposable.dispose()
    }

    open fun bind(view: T) {
        this.view = view
    }
}