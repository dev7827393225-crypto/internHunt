package com.example.internhunt.ui.Profile.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue

fun getColorFromName(name: String): Color {
    val colors = listOf(
        Color(0xFFEF5350),
        Color(0xFFAB47BC),
        Color(0xFF5C6BC0),
        Color(0xFF29B6F6),
        Color(0xFF66BB6A),
        Color(0xFFFFCA28)
    )
    return colors[name.hashCode().absoluteValue % colors.size]
}
@Composable
fun CompanyInitialLogo(companyName: String) {

    val bgColor = getColorFromName(companyName)
    val initial = companyName
        .trim()
        .firstOrNull()
        ?.uppercase()
        ?: "?"

    Box(
        modifier = Modifier
            .size(59.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White
        )
    }
}
