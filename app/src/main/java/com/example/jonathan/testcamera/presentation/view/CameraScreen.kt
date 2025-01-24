package com.example.jonathan.testcamera.presentation.view

import android.graphics.ImageDecoder
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.jonathan.testcamera.presentation.viewmodel.CameraViewModel

@Composable
fun CameraScreen(viewModel: CameraViewModel) {
    val context = LocalContext.current
    val capturedImageUri by viewModel.capturedImageUri.collectAsState()

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = { bitmap ->
            if (bitmap != null) {
                // Process and display the bitmap
                Toast.makeText(context, "Picture captured successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Picture capture failed!", Toast.LENGTH_SHORT).show()
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        capturedImageUri?.let { uri ->
            Image(
                //bitmap = uri.asImageBitmap(),
                bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(context.contentResolver, uri)).asImageBitmap(),
                contentDescription = "Captured Image",
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { cameraLauncher.launch() },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Take Picture", color = Color.White)
        }
    }
}
