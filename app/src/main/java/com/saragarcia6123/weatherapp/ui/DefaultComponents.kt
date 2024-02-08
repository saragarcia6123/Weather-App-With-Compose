package com.saragarcia6123.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

class DefaultComponents {

    private val borderRadius = 24.dp
    private val cardElevation = 16.dp

    @Composable
    fun Card(cardContent: CardContent, imageResource: Int, contentDescriptionResource: Int, cardHeight: Int, shadowBrush: Brush, modifier: Modifier) {
        ImageCard(imageResource = imageResource, contentDescriptionResource = contentDescriptionResource, cardHeight = cardHeight, shadowBrush = shadowBrush, modifier = modifier.fillMaxWidth())
    }

    @Composable
    fun Card(cardContent: CardContent, backgroundColor: Color, cardHeight: Int, shadowBrush: Brush, modifier: Modifier) {
        SolidCard(backgroundColor = backgroundColor, cardHeight = cardHeight, shadowBrush = shadowBrush, modifier = modifier.fillMaxWidth())
    }

    @Composable
    private fun ImageCard(imageResource: Int, contentDescriptionResource: Int, cardHeight: Int, shadowBrush: Brush, modifier: Modifier) {

        val painter = painterResource(id = imageResource)
        val contentDescription = LocalContext.current.getString(contentDescriptionResource)

        Card(
            shape = RoundedCornerShape(borderRadius),
            elevation = CardDefaults.cardElevation(cardElevation),
            modifier = modifier
        ) {
            Box(modifier = Modifier.height(cardHeight.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }

    @Composable
    private fun SolidCard(backgroundColor: Color, cardHeight: Int, shadowBrush: Brush, modifier: Modifier) {
        Card (
            shape = RoundedCornerShape(borderRadius),
            elevation = CardDefaults.cardElevation(cardElevation),
            modifier = modifier
        ) {
            Box(modifier = Modifier.height(cardHeight.dp)) {

            }
        }
    }

    @Composable
    private fun BoxShadow(painter: Painter, contentDescription: String, boxHeight: Int, shadowBrush: Brush) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = shadowBrush)
        )
    }

    @Composable
    fun ClickableIcon(iconResource: Int, contentDescription: String, iconSize: Int, iconColor: Color, onClick: () -> Unit, modifier: Modifier = Modifier) {
        val painter = ImageVector.vectorResource(id = iconResource)
        Icon(
            imageVector = painter,
            contentDescription = contentDescription,
            modifier = modifier
                .width(iconSize.dp)
                .height(iconSize.dp)
                .background(iconColor)
        )
    }

}

sealed class CardContent {


}

sealed class BoxShadow {

}