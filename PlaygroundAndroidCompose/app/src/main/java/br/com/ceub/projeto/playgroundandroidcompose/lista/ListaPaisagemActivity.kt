package br.com.ceub.projeto.playgroundandroidcompose.lista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.R
import br.com.ceub.projeto.playgroundandroidcompose.lista.data.PaisagemDataSource
import br.com.ceub.projeto.playgroundandroidcompose.lista.model.Paisagem
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

@OptIn(ExperimentalFoundationApi::class)
class ListaPaisagemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    AppLista()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppLista() {
    PaisagemGrid(lista = PaisagemDataSource().consultarPaisagens())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaisagemCard(paisagem: Paisagem, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = paisagem.idImg),
                contentDescription = paisagem.descricao,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = paisagem.descricao,
                modifier = Modifier.padding(all = 16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaisagemGrid(lista: List<Paisagem>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(lista) { paisagem ->
            PaisagemCard(paisagem = paisagem, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun AppListaPreview() {
    AppLista()
}
