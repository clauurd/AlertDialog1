package com.example.alertdialog1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alertdialog1.ui.theme.AlertDialog1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialog1Theme {
                MiInterfaz()
            }
        }
    }
}

@Composable
fun MiInterfaz() {
    var show by remember { mutableStateOf(false) }
    var show2 by remember { mutableStateOf(false) }
    var show2_2 by remember { mutableStateOf(false) }
    var show3 by remember { mutableStateOf(false) }
    var show4 by remember { mutableStateOf(false) }
    var show5 by remember { mutableStateOf(false) }
    var show5_5 by remember { mutableStateOf(false) }
    var mensajeTexto by remember { mutableStateOf("Hola a todos") }
    var mensajeTextoAutenticar by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }// Variable para almacenar el texto

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround  // Distribuye los elementos con espacio entre ellos
    ) {
        // Primer Boton
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { show = true }) {
                Text(text = "Confirmación de acción")
            }
            Spacer(modifier = Modifier.height(8.dp))
            MiTexto(mensajeTexto)
        }

        // Segundo Boton
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { show2 = true }) {
                Text(text = "Eliminar elemento")
            }


        }
        //Tercer boton
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { show3 = true }) {
                Text(text = "Aviso importante")
            }


        }
        //Cuarto botón
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { show4 = true }) {
                Text(text = "Requiere autenticación")
            }
            Spacer(modifier = Modifier.height(8.dp))
            MiTexto(mensajeTextoAutenticar)


        }
        //Quinto Botón
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { show5 = true }) {
                Text(text = "Error Crítico")
            }


        }


//----------------------------------------------------------------------------------------------------------------
        // Mostrar el diálogo cuando `show` es verdadero
        if (show) {
            MyAlertDialog(
                show = show,
                title = "Confirmación de Acción",
                message = "¿Estás seguro de que deseas continuar con esta acción?",
                confirmButtonText = "Sí",
                dismissButtonText = "No",
                onDismiss = { show = false },
                onConfirm = {mensajeTexto = "Acción Realizada"
                    show = false       // Oculta el primer diálogo

                }
            )
        }

        // Segundo diálogo de eliminación exitosa
        if (show2) {
            MyAlertDialog(
                show = show2,
                title = "Eliminar elemento",
                message = "Esta acción es irreversible. ¿Deseas eliminar este elemento?",
                confirmButtonText = "Eliminar",
                dismissButtonText = "Cancelar",
                onDismiss = { show2 = false },
                onConfirm = { show2 = false
                    show2_2 = true }
            )
        }
        if (show2_2) {
            MyAlertDialog(
                show = show2_2,
                title = "Eliminar elemento",
                message = "Eliminación exitosa",
                confirmButtonText = "Ok",
                dismissButtonText = "",
                onDismiss = { show2_2 = false },
                onConfirm = { show2_2 = false }  // Cierra el segundo diálogo
            )
        }
        if (show3) {
            MyAlertDialog(
                show = show3,
                title = "Aviso importante",
                message = "Recuerda que los cambios realizados no se pueden deshacer ",
                confirmButtonText = "Entendido",
                dismissButtonText = "",
                onDismiss = { show3 = false },
                onConfirm = {
                    show3 = false

                }
            )
        }
        if (show4) {
            MyAlertDialog(
                show = show4,
                title = "Requiere Autenticación",
                message = "Para continuar, necesitas autenticarte de nuevo",
                confirmButtonText = "Autentica",
                dismissButtonText = "Cancelar",
                onDismiss = { show4 = false },
                onConfirm = {mensajeTextoAutenticar = "Usuario Autenticado"
                    show4 = false       // Oculta el primer diálogo

                }
            )
        }
        if (show5) {
            MyAlertDialog(
                show = show5,
                title = "Error Critico",
                message = "Se ha producido un error crítico. ¿Deseas intentar nuevamente?",
                confirmButtonText = "Reintentar",
                dismissButtonText = "Cancelar",
                onDismiss = { show5 = false },
                onConfirm = {show5_5 = true
                    show5 = false       // Oculta el primer diálogo

                }
            )
        }
        if (show5_5) {
            MyAlertDialog(
                show = show5_5,
                title = "Intento de reintento",
                message = "",
                confirmButtonText = "Ok",
                dismissButtonText = "",
                onDismiss = { show5_5 = false },
                onConfirm = { show5_5 = false }  // Cierra el segundo diálogo
            )
        }

    }
}



@Composable
fun MiTexto(text: String) {
    Text(text = text)
}


@Composable
fun MyAlertDialog(
    show: Boolean,
    title: String,
    message: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = dismissButtonText)
                }
            }
        )
    }
}






