package br.com.ceub.projeto.playgroundandroidcompose.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue



class CalculadoraActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    AppCalculadora()

                }
            }
        }
    }
}

@Composable
fun AppCalculadora(){

    Column (modifier = Modifier
        .statusBarsPadding()
        .padding(40.dp)
        .verticalScroll(
            rememberScrollState()
        )
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(text = "Etanol X Gasolina", color = Color.White, style = MaterialTheme.typography.titleLarge, modifier = Modifier
            .padding(bottom = 16.dp)
            .align(Alignment.Start))

        CampoNumero()

        Text(text = "Resultado Abasteça com Gasolina", color = Color.White, style = MaterialTheme.typography.titleLarge)

    }

}

@Composable
fun CampoNumero(modifier: Modifier = Modifier
    .fillMaxWidth()
    .padding(bottom = 32.dp)){

    var valorEntrada by remember {
        mutableStateOf("0")
    }

    var valorGasolinaNumero = valorEntrada.toDoubleOrNull() ?: 0.0

    var resultado = calcularEtanolVersusGasolina(valorGasolina = valorEntrada.toDouble())

    TextField(modifier = modifier, label = { Text(text = "R$ Gasolina")},value = valorEntrada, onValueChange = {valorEntrada = it})
}

private fun calcularEtanolVersusGasolina(
    valorGasolina : Double,
    valorEtanol : Double = 3.89,
):String {

    val porcentagem = valorEtanol / valorGasolina
    if(porcentagem > 0.7){
        return "Vantagem em abastecer com gasolina" + "Porcentagem em: $porcentagem"
    }
    return "Vantagem em abastecer com etanol" + "Porcentagem em: $porcentagem"
}

@Preview
@Composable
fun AppCalculadoraPreview() {
    PlaygroundAndroidComposeTheme {
        Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
            AppCalculadora()
        }
    }
}