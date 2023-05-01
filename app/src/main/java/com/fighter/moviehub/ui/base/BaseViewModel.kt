package com.fighter.moviehub.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    protected abstract val tag: String

    protected fun addToCompositeDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    protected open fun log(message: String) {
        Log.v(tag, message)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}