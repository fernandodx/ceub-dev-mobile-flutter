import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class CalculadoraAlcoolGasolinaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    CalculadoraApp()
                }
            }
        }
    }
}

@Composable
fun CalculadoraApp() {
    var valorGasolina by remember { mutableStateOf("5.39") }
    var valorEtanol by remember { mutableStateOf("3.86") }
    var switchChecked by remember { mutableStateOf(false) }

    val valorGasolinaNumerico = valorGasolina.toDoubleOrNull() ?: 0.0
    val valorEtanolNumerico = valorEtanol.toDoubleOrNull() ?: 0.0

    val porcentagem = if (switchChecked) 0.75 else 0.7

    val textoResultado = if (valorEtanolNumerico / valorGasolinaNumerico > porcentagem) {
        "Vantagem em abastecer com Gasolina."
    } else {
        "Vantagem em abastecer com Etanol."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        CampoNumerico(
            valor = valorGasolina,
            onValorAlterado = { valorGasolina = it },
            label = stringResource(id = R.string.gasolina_label)
        )
        CampoNumerico(
            valor = valorEtanol,
            onValorAlterado = { valorEtanol = it },
            label = stringResource(id = R.string.etanol_label)
        )
        Switch(
            checked = switchChecked,
            onCheckedChange = { switchChecked = it },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = textoResultado,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}

@Composable
fun CampoNumerico(
    valor: String,
    onValorAlterado: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = valor,
        onValueChange = onValorAlterado,
        label = { Text(text = label) },
        modifier = modifier
            .padding(bottom = 16.dp)
    )
}

@Preview
@Composable
fun CalculadoraAppPreview() {
    PlaygroundAndroidComposeTheme {
        Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
            CalculadoraApp()
        }
    }
}
