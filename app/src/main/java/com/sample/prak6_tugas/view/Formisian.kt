package com.sample.prak6_tugas.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDataDiri(
    onSubmitClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var textSP by remember { mutableStateOf(value = "") }

    var nama by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }
    var status by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusKawin: List<String> = listOf("Janda", "Lajang", "Duda")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Formulir Pendaftaran", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ){
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "NAMA LENGKAP",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    textNama = it
                }
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "JENIS KELAMIN",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Column {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = textJK == item,
                                onClick = {
                                    textJK = item
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            }
                        )
                        Text(text = item)
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "STATUS PERKAWINAN",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}