package com.example.assignment.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.R
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.ui.theme.PrimaryColor
import com.example.assignment.ui.theme.SecondaryColor
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

@SuppressLint("NewApi")
@Composable
fun ActivityScreen() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        AndroidThreeTen.init(context)

        TopBar()
        val currentDate by remember { mutableStateOf(LocalDate.now()) }
        val formattedDate by remember {
            mutableStateOf(
                currentDate.format(
                    DateTimeFormatter.ofPattern(
                        "EEEE, MMM dd"
                    )
                )
            )
        }
        Text(text = "Today", fontWeight = FontWeight.W500, fontSize = 20.sp, color = Color.Black)
        Text(text = formattedDate, modifier = Modifier.padding(8.dp))
      CircularProgressBar(200, PrimaryColor)
    }
}

@Composable
fun CircularProgressBar(size: Int, color: Color) {

    Box(modifier = Modifier.size(size.dp)) {
        androidx.compose.foundation.Canvas(modifier = Modifier.size(100.dp)) {
            drawArc(color = color, startAngle = -90f, 360f, useCenter = false, style = Stroke(8.dp.toPx(), cap = StrokeCap.Round))
        }
    }

}

@Composable
fun TopBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            "Dietsnap",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W500,
            fontSize = 24.sp,
            color = PrimaryColor,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.notification),
            null,
            modifier = Modifier.padding()
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.achievements),
            null,
            modifier = Modifier.padding(24.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.message),
            null,
            modifier = Modifier.padding()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ActivityPrev() {
    AssignmentTheme {
        ActivityScreen()
    }
}