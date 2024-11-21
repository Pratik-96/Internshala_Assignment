package com.example.assignment.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
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
        Text(text = "Today", fontWeight = FontWeight.W500, fontSize = 20.sp)
        Text(text = formattedDate, modifier = Modifier.padding(8.dp))
        Spacer(Modifier.padding(8.dp))
        Box(modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center) {
            CircularProgressBar(200, PrimaryColor.copy(0.5f))
            CircularProgressBar(170, SecondaryColor.copy(0.5f))
            Text(
                text = "SET GOAL!",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.diet),
                null,
                tint = PrimaryColor
            )
            Text("Diet Pts", fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(8.dp))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.exercise),
                null,
                tint = SecondaryColor
            )
            Text(
                "Exercise Pts",
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(8.dp)
            )

        }

        WorkoutData()

        Goals()

        Explore()


    }
}

@Composable
fun Explore() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Explore",
            fontWeight = FontWeight.W500,
            fontSize = 24.sp,
            modifier = Modifier
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.explore),
                null,
                modifier = Modifier
                    .width(54.dp)
                    .height(54.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Find Diets",
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
                Text(
                    text = "Find premade diets according to your cuisine",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.nutrition),
                null,
                modifier = Modifier
                    .width(54.dp)
                    .height(54.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Find Nutritionist",
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
                Text(
                    text = "Get customized diets to achieve your health goal",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun Goals() {

    Column(horizontalAlignment = Alignment.Start) {

        Text(
            text = "Goals",
            fontWeight = FontWeight.W500,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .background(
                    color = Color(0xFF64B5F6).copy(0.2f),
                    shape = RoundedCornerShape(16.dp)
                ),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.workout),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .height(54.dp)
                    .width(54.dp)
            )
            Column(modifier = Modifier.width(160.dp)) {
                Text(
                    text = "Chest Workout with Dumbbells & Barbell",
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp
                )
                Text(text = "Current Major Goal", fontSize = 16.sp, color = Color.Gray)
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(50.dp)
                    .weight(1f), contentAlignment = Alignment.Center
            ) {
                androidx.compose.foundation.Canvas(modifier = Modifier.size(50.dp)) {
                    drawArc(
                        color = PrimaryColor,
                        startAngle = -90f,
                        360 * 0.35f,
                        useCenter = false,
                        style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
                Text("35%")
            }


        }
    }
}

@Composable
fun WorkoutData() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.weight(0.8f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("1500", fontFamily = FontFamily.SansSerif, fontSize = 18.sp, color = PrimaryColor)
            Text("Cal", fontFamily = FontFamily.SansSerif, fontSize = 18.sp)
        }
        Spacer(Modifier.weight(1f))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("3/5", fontFamily = FontFamily.SansSerif, fontSize = 18.sp, color = PrimaryColor)
            Text(
                "Days",
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
            )
        }
        Spacer(Modifier.weight(0.6f))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("88", fontFamily = FontFamily.SansSerif, fontSize = 16.sp, color = PrimaryColor)
            Text("Health Score", fontFamily = FontFamily.SansSerif, fontSize = 16.sp)
        }
        Spacer(Modifier.weight(0.5f))

    }


}

@Composable
fun CircularProgressBar(size: Int, color: Color) {

    Box(modifier = Modifier.size(size.dp), contentAlignment = Alignment.Center) {
        androidx.compose.foundation.Canvas(modifier = Modifier.size(size.dp)) {
            drawArc(
                color = color,
                startAngle = -90f,
                360f,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )
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