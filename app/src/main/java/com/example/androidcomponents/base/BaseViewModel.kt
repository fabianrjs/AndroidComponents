package com.example.androidcomponents.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidcomponents.utils.INSTANCES_TAG

open class BaseViewModel: ViewModel() {

    init {
        Log.i(INSTANCES_TAG, "${this::class.simpleName} created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(INSTANCES_TAG, "${this::class.simpleName} destroyed")
    }
}
