package br.com.ceub.projeto.playgroundandroidcompose.lista.data

import br.com.ceub.projeto.playgroundandroidcompose.R
import br.com.ceub.projeto.playgroundandroidcompose.lista.model.Paisagem

class PaisagemDataSource {

    fun consultarPaisagem() :List<Paisagem> {

        val listaPaisagens = listOf(
            Paisagem(R.drawable.image1, descricao = "Imagem 1"),
            Paisagem(R.drawable.image2, descricao = "Imagem 2"),
            Paisagem(R.drawable.image3, descricao = "Imagem 3"),
            Paisagem(R.drawable.image4, descricao = "Imagem 4"),
            Paisagem(R.drawable.image5, descricao = "Imagem 5"),
            Paisagem(R.drawable.image6, descricao = "Imagem 6"),
            Paisagem(R.drawable.image7, descricao = "Imagem 7"),
            Paisagem(R.drawable.image8, descricao = "Imagem 8"),
            Paisagem(R.drawable.image9, descricao = "Imagem 9"),
            Paisagem(R.drawable.image10, descricao = "Imagem 10"),
        )
        return listaPaisagens
    }
}