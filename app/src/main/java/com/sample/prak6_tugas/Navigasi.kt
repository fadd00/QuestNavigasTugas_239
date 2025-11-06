package com.sample.prak6_tugas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class navigasi {
    Home,
    Formulir,
    Detail
}

@Composable
fun DataApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){

}