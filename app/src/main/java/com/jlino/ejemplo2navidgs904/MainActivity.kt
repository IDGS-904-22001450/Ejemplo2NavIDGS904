package com.jlino.ejemplo2navidgs904

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jlino.ejemplo2navidgs904.screens.FirstScreen
import com.jlino.ejemplo2navidgs904.screens.SecondScreen
import com.jlino.ejemplo2navidgs904.ui.theme.Ejemplo2NavIDGS904Theme
import java.nio.file.WatchEvent
import androidx.navigation.compose.composable
import com.jlino.ejemplo2navidgs904.screens.SumaDosNumero

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SumaDosNumero()
           /*
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination="Inicio"){
                composable("Inicio"){PantallaInicio(navController)}
                composable("Detalle/{nombre}") { backStackEntry->
                    val nombre =backStackEntry.arguments?.getString("nombre") ?: "Invitado"
                    PantallaDetalle(navController,nombre)
                }
            }*/

        }
    }
}

@Composable
fun PantallaInicio(navController: NavHostController){
    var nombre by remember{ mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Pantall de inicio")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Ingrese su nombre")},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val nombre = nombre.ifBlank { "Cardiel" }
                navController.navigate("detalle/$nombre")
            })
        {
        Text("Ir a detalle de compra")
        }
    }
}

@Composable
fun PantallaDetalle(navController: NavHostController, nombre:String){
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text("Hola $nombre")
       Button(onClick = {navController.navigate("inicio")}){
           Text("Volver")
       }
    }
}

