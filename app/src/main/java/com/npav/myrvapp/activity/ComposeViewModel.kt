package com.npav.myrvapp.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ComposeViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = _stateFlow.asStateFlow()

    fun updateStateFlow(newState: Int) {
        _stateFlow.update { currentState ->
            newState

        }
        Log.e("newState", _stateFlow.value.toString())
    }

}