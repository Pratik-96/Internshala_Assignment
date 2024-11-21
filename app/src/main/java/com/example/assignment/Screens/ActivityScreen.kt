package com.example.assignment.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.R
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.ui.theme.PrimaryColor
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlin.text.format
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.TextStyle

@SuppressLint("NewApi")
@Composable
fun ActivityScreen() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        AndroidThreeTen.init(context)

        TopBar()
        val currentDate by remember { mutableStateOf(LocalDate.now()) }
        val formattedDate by remember { mutableStateOf(currentDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"))) }
        Text(formattedDate)

    }
}


@Composable
fun TopBar() {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {

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
            modifier = Modifier.padding( )
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