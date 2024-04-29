package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class JogarDadosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub,
                    modifier = Modifier.fillMaxSize()) {
                    JogarDadosApp()

                }
            }
        }
    }
}

@Composable
fun JogarDadosApp() {
    ImagemDadoComBotao()


}

@Composable
fun ImagemDadoComBotao(){
    
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Jogar")
    }

}

@Preview
@Composable
fun JogarDadosAppPreview(){
    ImagemDadoComBotao()
}