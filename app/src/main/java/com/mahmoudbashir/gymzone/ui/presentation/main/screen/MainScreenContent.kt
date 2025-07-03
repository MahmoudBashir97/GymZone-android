package com.mahmoudbashir.gymzone.ui.presentation.main.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudbashir.gymzone.ui.data.models.ExerciseEntry
import com.mahmoudbashir.gymzone.ui.theme.DarkBlue
import com.mahmoudbashir.gymzone.ui.theme.GymZoneTheme

object MainScreenContent {

    @Composable
    fun Content() {
        val exerciseList = remember {
            mutableStateListOf(
                ExerciseEntry(exercise = "Bench Press", sets = 3, reps = 10, weight = "80 kg", repTime = "2s", notes = "Focus on form"),
                ExerciseEntry(exercise = "Bench Press1", sets = 3, reps = 10, weight = "80 kg", repTime = "2s", notes = "Focus on form"),
                ExerciseEntry(exercise = "Bench Press2", sets = 3, reps = 10, weight = "80 kg", repTime = "2s", notes = "Focus on form"),
                ExerciseEntry(exercise = "Bench Press3", sets = 3, reps = 10, weight = "80 kg", repTime = "2s", notes = "Focus on form"),
            )
        }

        GymZoneTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            exerciseList.add(ExerciseEntry())
                        },
                        containerColor = DarkBlue,
                        shape = CircleShape
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add Exercise",
                            tint = Color.White
                        )
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Image(
                        painter = painterResource(com.mahmoudbashir.gymzone.R.drawable.w1),
                        contentDescription = null
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White.copy(alpha = 0.6f))
                    )
                }
                ExerciseTable(
                    modifier = Modifier.padding(innerPadding),
                    list = exerciseList
                )
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun ExerciseTable(modifier: Modifier, list: MutableList<ExerciseEntry>) {
        val headers = listOf("Exercise", "Sets", "Reps", "Weight", "Rep Time", "Notes")
        val textStyle = TextStyle(
            fontStyle = FontStyle.Normal,
            fontSize = 8.sp
        )

        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 3.dp)
        ) {
            stickyHeader {
                Row(
                    modifier = Modifier
                        .background(Color(0xFFADD8E6))
                ) {
                    headers.forEach { title ->
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .weight(1f)
                                .border(0.7.dp, Color.Black, RectangleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = title,
                                style = TextStyle(
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 11.sp
                                ),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            itemsIndexed(
                items = list,
                key = { _, item -> item.id }) { index, entry ->
                SwipeableRow(
                    entry = entry,
                    onDelete = { list.removeAt(index) },
                    onEdit = {
                        // You can handle edit here, e.g., show a dialog
                        println("Edit clicked on item index $index")
                    },
                    textStyle = textStyle
                )
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun SwipeableRow(
        entry: ExerciseEntry,
        onDelete: () -> Unit,
        onEdit: () -> Unit,
        textStyle: TextStyle
    ) {

        val dismissState = rememberDismissState()

        if (dismissState.isDismissed(DismissDirection.EndToStart)) {
            LaunchedEffect (Unit) {
                onDelete()
                dismissState.snapTo(DismissValue.Default)
            }
        }

        if (dismissState.isDismissed(DismissDirection.StartToEnd)) {
            LaunchedEffect(Unit) {
                onEdit()
                dismissState.snapTo(DismissValue.Default)
            }
        }

        SwipeToDismiss(
            state = dismissState,
            directions = setOf(
                DismissDirection.StartToEnd,
                DismissDirection.EndToStart
            ),
            background = {
                val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                val color = when (direction) {
                    DismissDirection.StartToEnd -> Color(0xFF4CAF50) // Green for edit
                    DismissDirection.EndToStart -> Color(0xFFF44336) // Red for delete
                }
                val icon = when (direction) {
                    DismissDirection.StartToEnd -> Icons.Default.Edit
                    DismissDirection.EndToStart -> Icons.Default.Delete
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color)
                        .padding(horizontal = 20.dp),
                    contentAlignment = when (direction) {
                        DismissDirection.StartToEnd -> Alignment.CenterStart
                        DismissDirection.EndToStart -> Alignment.CenterEnd
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            dismissContent = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    val boxModifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .border(0.7.dp, Color.Black, RectangleShape)

                    ExerciseRowItem(boxModifier, entry.exercise, textStyle)
                    ExerciseRowItem(boxModifier, entry.sets.toString(), textStyle)
                    ExerciseRowItem(boxModifier, entry.reps.toString(), textStyle)
                    ExerciseRowItem(boxModifier, entry.weight, textStyle)
                    ExerciseRowItem(boxModifier, entry.repTime, textStyle)
                    ExerciseRowItem(boxModifier, entry.notes, textStyle)
                }
            }
        )
    }

    @Composable
    fun ExerciseRowItem(
        modifier: Modifier,
        title: String,
        textStyle: TextStyle
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = textStyle,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                textAlign = TextAlign.Center
            )
        }
    }
}
