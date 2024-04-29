package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.Purple40

class ApresentacaoUsuarioActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            PlaygroundAndroidComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Purple40
                ) {
                    }

                }
            }
        }
    }
@Composable
fun CardApresentacao(){
    Column {
        painter - painterResource(id = R.drawable.ic_user),
        ContentDescripition = "",
        modifirer
    }

}
@Preview
@Composable
fun CardApresentacaoPreview(){
    PlaygroundAndroidComposeTheme {
        Surface {
            modifier = Modifier.fillMaxSize(),
            color = Purple40 (

            )
        }
    }
}