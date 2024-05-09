package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class CalculadoraEtanolGasolina : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface (color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    AppCalculadora()
                }
            }
        }
    }
}

@Composable
fun AppCalculadora() {

}

@Preview
@Composable

fun AppCalculadoraPreview(){
    PlaygroundAndroidComposeTheme {
        Surface (color = CorCeub, modifier = Modifier.fillMaxSize()) {
            AppCalculadora()
        }
    }
}
