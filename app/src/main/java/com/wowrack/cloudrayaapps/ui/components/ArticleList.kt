package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.data.dummy.getDummyArticle
import com.wowrack.cloudrayaapps.data.model.Article
import com.wowrack.cloudrayaapps.data.model.ArticleData
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.utils.truncateText

@Composable
fun ArticleList(
    data: List<ArticleData>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 5.dp)
    ) {
        items(data, key = { it.id }) { article ->
            ArticleItem(article)
        }
    }
}

@Composable
fun ArticleItem(
    article: ArticleData,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(300.dp)
            .height(120.dp)
            .shadow(8.dp, RoundedCornerShape(8.dp))
            .clickable {

            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Column(
            modifier.padding(16.dp),
        ) {
            Text(
                text = article.title.truncateText(70),
                fontFamily = poppins,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = modifier
                    .width(IntrinsicSize.Max)
                    .background(Color.LightGray, RoundedCornerShape(4.dp))
                    .padding(2.dp)
            ) {
                Text(
                    text = article.categories.name,
                    fontFamily = poppins,
                    fontSize = 12.sp,
                    modifier = modifier
                )
            }
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "By ${article.creator.name}",
//                fontFamily = poppins,
//                fontSize = 12.sp,
//                maxLines = 3,
//                modifier = modifier
//            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    CloudRayaAppsTheme {
//        ArticleList()
//    }
//}