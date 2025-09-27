package com.example.examenprogramovil.features.dollar.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DollarScreen(viewModelDollar: DollarViewModel = koinViewModel()) {
    val state = viewModelDollar.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (val stateValue = state.value) {
            is DollarViewModel.DollarUIState.Error -> {
                Text(
                    text = "Error: ${stateValue.message}",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            DollarViewModel.DollarUIState.Loading -> {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(12.dp))
                Text("Cargando...")
            }

            is DollarViewModel.DollarUIState.Success -> {
                val data = stateValue.data
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "💵 Tipo de Cambio",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text("Oficial Compra: ${data.dollarOficialCompra ?: "--"}")
                        Text("Oficial Venta: ${data.dollarOficialVenta ?: "--"}")
                        Text("Paralelo Compra: ${data.dollarParaleloCompra ?: "--"}")
                        Text("Paralelo Venta: ${data.dollarParaleloVenta ?: "--"}")

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Última actualización: ${sdf.format(Date(data.timestamp))}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}