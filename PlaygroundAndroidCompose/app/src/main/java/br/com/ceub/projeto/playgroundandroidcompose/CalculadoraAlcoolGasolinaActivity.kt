package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme
import java.text.NumberFormat
import java.util.*

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
    var valorGasolina by remember { mutableStateOf("5,39") }
    var valorEtanol by remember { mutableStateOf("3,86") }
    var isSwitchChecked by remember { mutableStateOf(false) }

    val formatadorNumero = NumberFormat.getNumberInstance(Locale("pt", "BR"))
    val valorGasolinaNumerico = formatadorNumero.parse(valorGasolina)?.toDouble() ?: 0.0
    val valorEtanolNumerico = formatadorNumero.parse(valorEtanol)?.toDouble() ?: 0.0

    val textoResultado = calcularEtanolVersusGasolina(
        valorGasolina = valorGasolinaNumerico,
        valorEtanol = valorEtanolNumerico,
        use75Percent = isSwitchChecked
    )

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.etanol_x_gasolina),
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.titleLarge
        )
        CampoNumerico(
            valor = valorGasolina,
            onValorAlterado = { valorGasolina = it },
            label = stringResource(id = R.string.label_gasolina),
            icone = R.drawable.ic_gasolina
        )
        CampoNumerico(
            valor = valorEtanol,
            onValorAlterado = { valorEtanol = it },
            label = stringResource(id = R.string.label_etanol),
            icone = R.drawable.ic_etanol
        )
        Switch(
            checked = isSwitchChecked,
            onCheckedChange = { isSwitchChecked = it },
            modifier = Modifier.padding(top = 16.dp)
        )
        {
            Text(text = stringResource(id = R.string.switch_label))
        }
        Text(
            text = textoResultado,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun CampoNumerico(
    valor: String,
    onValorAlterado: (String) -> Unit,
    label: String,
    icone: Int? = null,
    modifier: Modifier = Modifier
        .padding(bottom = 32.dp)
        .fillMaxWidth()
) {
    TextField(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                icone?.let {
                    Icon(
                        painter = painterResource(id = icone),
                        contentDescription = label,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(text = label)
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        value = valor,
        onValueChange = onValorAlterado,
        modifier = modifier
    )
}

private fun calcularEtanolVersusGasolina(
    valorGasolina: Double,
    valorEtanol: Double,
    use75Percent: Boolean
): String {
    val porcentagem = if (use75Percent) valorEtanol / valorGasolina * 0.75 else valorEtanol / valorGasolina
    val porcentagemFmt = NumberFormat.getPercentInstance().format(porcentagem)
    return if (porcentagem > 0.7) {
        "Vantagem em abastecer com Gasolina. Porcentagem em: $porcentagemFmt"
    } else {
        "Vantagem em abastecer com Etanol. Porcentagem em: $porcentagemFmt"
    }
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
