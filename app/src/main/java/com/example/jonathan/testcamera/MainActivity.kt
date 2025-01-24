package com.example.jonathan.testcamera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jonathan.testcamera.presentation.view.CameraScreen
import com.example.jonathan.testcamera.presentation.viewmodel.CameraViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CameraScreen(
                viewModel = CameraViewModel()
            )
        }
    }
}
