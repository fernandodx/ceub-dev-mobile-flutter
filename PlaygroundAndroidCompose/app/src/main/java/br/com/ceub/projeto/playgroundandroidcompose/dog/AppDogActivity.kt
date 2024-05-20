package br.com.ceub.projeto.playgroundandroidcompose.dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.dog.model.Dog
import br.com.ceub.projeto.playgroundandroidcompose.dog.model.listaDogs
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class AppDogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppDog()
                }
            }
        }
    }
}

@Composable
fun AppDog() {
    LazyColumn {
        items(listaDogs) { dog ->
            DogItem(dog = dog, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun AppDogPreview() {
    PlaygroundAndroidComposeTheme(darkTheme = true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            AppDog()
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {

    var iconeExpandido by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = 70.dp,
            bottomEnd = 35.dp,
            bottomStart = 16.dp,
            topEnd = 0.dp
        )
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = dog.img),
                    contentDescription = dog.nome,
                    modifier = modifier
                        .size(75.dp)
                        .padding(16.dp)
                        .clip(MaterialTheme.shapes.large),
                    contentScale = ContentScale.Crop
                )
                InfoDog(dog = dog)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { iconeExpandido = !iconeExpandido }) {
                    Icon(
                        imageVector = if (iconeExpandido)
                            Icons.Filled.ExpandLess
                            else Icons.Filled.ExpandMore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            if(iconeExpandido){
                SobreDog(dog = dog)
            }

        }
    }
}

@Composable
fun SobreDog(dog: Dog) {
    Column(modifier = Modifier.padding(
        start = 32.dp,
        bottom = 8.dp)){
        Text(
            text = "Sobre:",
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = dog.hobbie,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Composable
fun InfoDog(dog: Dog) {
    Column {
        Text(
            text = dog.nome,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Idade: ${dog.idade}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
