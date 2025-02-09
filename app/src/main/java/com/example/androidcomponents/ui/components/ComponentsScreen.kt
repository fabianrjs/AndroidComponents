package com.example.androidcomponents.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun ComponentsScreen(
    navController: NavController,
    componentsViewModel: ComponentsViewModel = koinViewModel()
) {
    val components = componentsViewModel.components

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(20.dp)
                    .fillMaxWidth(),
                text = "Components",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = Color.White
            )
        }
        items(
            count = components.size,
            key = { index -> components[index].id },
            itemContent = { index ->
                ComponentCard(components[index], navController)
            }
        )
    }
}

@Composable
fun ComponentCard(component: Component, navController: NavController) {
    Row(
        modifier = Modifier
            .clickable { navController.navigate(component.route) }
            .background(Color.DarkGray)
            .padding(20.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${component.id}. ${component.name}",
            textAlign = TextAlign.Center,
        )
    }
}
