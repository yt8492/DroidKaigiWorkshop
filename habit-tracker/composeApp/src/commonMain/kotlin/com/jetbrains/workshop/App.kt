package com.jetbrains.workshop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinproject.composeapp.generated.resources.*
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.stringResource

@Composable
fun App(
    typegraphy: Typography = MaterialTheme.typography,
) {
    val viewModel = remember {
        HabitViewModel()
    }
    val habits = viewModel.habits.collectAsStateWithLifecycle().value
    MaterialTheme(
        typography = typegraphy
    ) {
        Box(Modifier.fillMaxSize().background(Color.White)) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = stringResource(Res.string.app_name)
                            )
                        }
                    )
                }
            ) { contentPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(habits) { habit ->
                        HabitElement(
                            habit = habit,
                            onClickCountUp = {
                                viewModel.countUp(it)
                            },
                            onClickCountDown = {
                                viewModel.countDown(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HabitElement(
    habit: HabitBindingModel,
    modifier: Modifier = Modifier,
    onClickCountUp: (HabitBindingModel) -> Unit,
    onClickCountDown: (HabitBindingModel) -> Unit,
) {
    Row(
        modifier = modifier
            .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = habit.exercise,
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                onClickCountDown(habit)
            },
            shape = CircleShape,
        ) {
            Text("-")
        }
        Text(habit.count.toString())
        Button(
            onClick = {
                onClickCountUp(habit)
            },
            shape = CircleShape,
        ) {
            Text("+")
        }
    }
}
