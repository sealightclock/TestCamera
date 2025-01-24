package com.example.jonathan.testcamera.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CameraViewModel : ViewModel() {

    private val _capturedImageUri = MutableStateFlow<Uri?>(null)
    val capturedImageUri: StateFlow<Uri?> = _capturedImageUri

    fun updateCapturedImageUri(uri: Uri?) {
        _capturedImageUri.value = uri
    }
}
