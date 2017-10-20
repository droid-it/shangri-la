package com.udit.shangri_la.base

/**
 * Created by Udit on 01/10/17.
 */
abstract class BasePresenter<T : BaseViewContract> {

    protected var view: T? = null

    fun destroy() {
        view = null
    }

    open fun bind(view: T) {
        this.view = view
    }
}