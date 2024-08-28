package com.mlsg.shortnews.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mlsg.shortnews.R
import com.mlsg.shortnews.data.entity.Article
import com.mlsg.shortnews.data.entity.NewsResponse
import com.mlsg.shortnews.ui.theme.Purple40

@Composable
fun Loader(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NewsList(response: NewsResponse){
    LazyColumn{
        items(response.articles){ article ->
            NormalTextComponent(textValue = article.title ?: "Not Available")
        }

    }
}

@Composable
fun NormalTextComponent(textValue: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp), text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            color = Color.Gray
        )
    )
}

@Composable
fun HeadingTextComponent(textValue: String, centerAligned: Boolean = false){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
        ),
        textAlign = if(centerAligned) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun NewsRowComponent(pageNo: Int, article: Article){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .background(Color.White)
    ) {
        AsyncImage(modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = R.drawable.image),
            error = painterResource(id = R.drawable.image))

        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article.title ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

        Spacer(modifier = Modifier.weight(1f))

        AuthorRowComponent(article.author ?: "", article.source?.name ?: "")

    }
}

@Composable
fun EmptyStateComponent(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.emptystate),
            contentDescription = "")
    }
    HeadingTextComponent(textValue = stringResource(id = R.string.empty_state_message),
        centerAligned = true)
}

@Composable
fun AuthorRowComponent(authorName: String, sourceName: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)){
        Text(text = authorName, style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            color = Color.Gray
        ))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = sourceName, style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif,
        ))
    }
}


@Preview
@Composable
fun NewsRowComponentPreview(){
    val article = Article(
        author = "Mr.ManuVenkat H S",
        title = "Hello news",
        description = "This is the description",
        urlToImage = ""
    )
    NewsRowComponent(pageNo = 0, article = article)
}