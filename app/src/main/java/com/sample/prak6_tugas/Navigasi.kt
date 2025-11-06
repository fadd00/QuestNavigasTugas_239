package com.sample.prak6_tugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = com.sample.prak6.navigasi.Home.name,
            modifier = modifier.padding(isiRuang)
        ) {
            composable(route = com.sample.prak6.navigasi.Home.name) {
                HomePage(
                    onNavigateToForm = {
                        navController.navigate(com.sample.prak6.navigasi.Formulir.name)
                    }
                )
            }
            composable(route = com.sample.prak6.navigasi.Formulir.name) {
                FormDataDiri(
                    onSubmitClick = {
                        navController.navigate(com.sample.prak6.navigasi.Detail.name)
                    }
                )
            }
            composable(route = com.sample.prak6.navigasi.Detail.name) {
                TampilData(
                    OnBackBtnClick = {
                        cancelAndBackToFormulir(navController)
                    },
                    onBackToHomeClick = {
                        navController.navigate(com.sample.prak6.navigasi.Home.name) {
                            popUpTo(com.sample.prak6.navigasi.Home.name) { inclusive = true }
                        }
                    }
                )
            }

        }

        }
}
private fun cancelAndBackToFormulir(
    navController: NavHostController
){
    navController.popBackStack(com.sample.prak6.navigasi.Formulir.name, inclusive = false)
}
