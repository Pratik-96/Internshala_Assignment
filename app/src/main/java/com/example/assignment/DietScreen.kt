package com.example.assignment

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.assignment.DataClasses.Data
import com.example.assignment.DataClasses.NutritionInfo
import com.example.assignment.ViewModels.MainViewModel
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.ui.theme.PrimaryColor
import com.google.gson.Gson

data class SimilarItems(val name: String, val image: Int)

val similar_items = mutableListOf(
    SimilarItems("Chicken Tandoor", R.drawable.img1),
    SimilarItems("Pulav", R.drawable.img2),
    SimilarItems("Dal Fry", R.drawable.img3)
)

class DietScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            AssignmentTheme {


            }
        }
    }
}

@Composable
fun DietScreenComp(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center

    ) {
        val viewModel: MainViewModel = viewModel()
        viewModel.fetchDataFromApi()
        val state = viewModel.fetchRecipe.value
        when {
            state.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
            }

            state.error != null -> {
                Text(state.error)
            }

            else -> {
                UI(navHostController,state.data)
            }
        }


    }
}

@Composable
fun UI(navHostController: NavHostController, data: Data?) {
    val facts: List<String> = data?.data?.generic_facts ?: listOf("null")
    Column(modifier = Modifier.fillMaxSize()) {

        ImageContainer(navHostController,data)

        Text(
            "Description", fontSize = 24.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            data?.data?.description.toString(),
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            "Macro Nutrients", fontSize = 24.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(16.dp)
        )

        val gson = Gson()

        val nutritionInfo:List<NutritionInfo> = gson.fromJson(data?.data?.nutrition_info,Array<NutritionInfo>::class.java).toList()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
                .background(color = Color(0xFF64B5F6).copy(0.2f), shape = RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(Modifier.weight(1f))
                Text("Per Serve", fontWeight = FontWeight.W500)

            }
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Black)
            )

            for (item in nutritionInfo) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(item.name, fontWeight = FontWeight.W500)
                    Spacer(Modifier.weight(1f))
                    Text("${item.value} ${item.units}")
                }
            }
        }


        Text(
            "Facts", fontSize = 24.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(16.dp)
        )

        LazyHorizontalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            rows = GridCells.Fixed(1)
        ) {
            items(facts) { item ->

                FactItem(item)

            }
        }

        Text(
            "Similar Items", fontSize = 24.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(16.dp)
        )

        LazyHorizontalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            rows = GridCells.Fixed(1)
        ) {
            items(similar_items) { item ->

                SimilarItemsDesign(item)

            }
        }


    }
}

@Composable
fun SimilarItemsDesign(item: SimilarItems) {

    Box(
        modifier = Modifier
            .width(220.dp)
            .padding(8.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {

        Image(
            painter = painterResource(item.image),
            null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))
        )
        Text(
            item.name,
            color = Color.White,
            fontWeight = FontWeight.W500,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun FactItem(item: String) {

    Column(
        modifier = Modifier
            .width(300.dp)
            .padding(8.dp)
            .background(color = Color(0xFFF8B944).copy(0.8f), shape = RoundedCornerShape(16.dp))
    ) {
        Text(
            "Do You Know ?", fontSize = 24.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            item,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp)
        )

    }

}

@Composable
fun ImageContainer(navHostController: NavHostController, data: Data?) {
    Box(modifier = Modifier.wrapContentSize()) {
        Image(
            painter = painterResource(R.drawable.biryani),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        val activityContext = LocalContext.current as Activity
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Black.copy(0.5f))
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                "Food Information",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                data?.data?.name.toString(),
                fontWeight = FontWeight.W500,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .background(Color.DarkGray.copy(0.6f), shape = RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                data?.data?.health_rating.toString(),
                fontWeight = FontWeight.W500,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                "out of 100",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        IconButton(
            onClick = {
                navHostController.navigateUp()
            },
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp)
                .align(Alignment.TopStart),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Black.copy(alpha = 0.1f))
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}