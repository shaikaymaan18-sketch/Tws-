package com.twswidget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.appwidget.cornerRadius
import androidx.compose.ui.graphics.Color

class TwsWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                TwsWidgetContent()
            }
        }
    }
}

@Composable
fun TwsWidgetContent() {
    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(Color(0xFF181C24))
            .cornerRadius(28.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            provider = ImageProvider(R.drawable.tws_device),
            contentDescription = "TWS Earbuds",
            modifier = GlanceModifier.size(110.dp)
        )
    }
}

