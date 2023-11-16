package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wowrack.cloudrayaapps.data.dummy.getDummyArticle
import com.wowrack.cloudrayaapps.data.model.Article
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
) {
    val dummyArticles = getDummyArticle()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),

    ) {
        items(dummyArticles, key = { it.id }) { article ->
            ArticleItem(article)
        }
    }
}

@Composable
fun ArticleItem(
    article: Article,
    modifier: Modifier = Modifier,
) {
    Card (
        modifier = modifier.width(360.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ){
        Column {
            AsyncImage(
                model = article.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
//            Image(
//                painter = painterResource(article.image),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(120.dp)
//                    .clip(RoundedCornerShape(8.dp))
//            )
//            Column(modifier = Modifier.padding(8.dp)) {
//                Text(
//                    text = menu.title,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.titleMedium.copy(
//                        fontWeight = FontWeight.ExtraBold
//                    ),
//                )
//                Text(
//                    text = menu.price,
//                    style = MaterialTheme.typography.titleSmall,
//                )
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CloudRayaAppsTheme {
        ArticleList()
    }
}