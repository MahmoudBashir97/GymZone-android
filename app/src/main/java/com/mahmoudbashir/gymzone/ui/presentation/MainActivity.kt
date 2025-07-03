package com.mahmoudbashir.gymzone.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mahmoudbashir.gymzone.ui.presentation.main.screen.MainScreenContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MainScreenContent.Content()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ExerciseTablePreview() {
//    val sampleData = listOf(
//        ExerciseEntry("Bench Press", 3, 10, "80 kg", "2s", "Focus on form"),
//        ExerciseEntry("Squats", 4, 8, "100 kg", "3s", "Go deep"),
//        ExerciseEntry("Deadlift", 3, 5, "120 kg", "2s", "Keep back straight")
//    )
//    ExerciseTable(modifier = Modifier, list = sampleData)
//}

































