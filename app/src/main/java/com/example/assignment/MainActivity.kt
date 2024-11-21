package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment.DataClasses.NavigationItem
import com.example.assignment.Screens.ActivityScreen
import com.example.assignment.Screens.CameraScreen
import com.example.assignment.Screens.FeedScreen
import com.example.assignment.Screens.GoalScreen
import com.example.assignment.Screens.ProfileScreen
import com.example.assignment.Screens.Screens
import com.example.assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentTheme {


                val items = mutableListOf(
                    NavigationItem(
                        "Activity",
                        ImageVector.vectorResource(R.drawable.activity),
                        route = Screens.ActivityScreen.route
                    ), NavigationItem(
                        "Goals",
                        ImageVector.vectorResource(R.drawable.graph),
                        route = Screens.GoalsScreen.route
                    ), NavigationItem(
                        "Camera",
                        ImageVector.vectorResource(R.drawable.camera),
                        route = Screens.CameraScreen.route

                    ), NavigationItem(
                        "Feed",
                        ImageVector.vectorResource(R.drawable.feed),
                        route = Screens.FeedScreen.route

                    ), NavigationItem(
                        "Profile",
                        ImageVector.vectorResource(R.drawable.profile),
                        route = Screens.ProfileScreen.route

                    )
                )

                val navController = rememberNavController()


                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

                Scaffold(bottomBar = {

                    NavigationBar {

                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.route)
                                },
                                icon = {
                                    Icon(item.selectedIcon, null)
                                },
                                label = {
                                    Text(item.title)
                                }
                            )
                        }

                    }

                }) { innerPadding ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = Screens.ActivityScreen.route
                        ) {
                            composable(route = Screens.ActivityScreen.route) {
                                ActivityScreen()
                            }
                            composable(route = Screens.GoalsScreen.route) {
                                GoalScreen()
                            }
                            composable(route = Screens.CameraScreen.route) {
                                CameraScreen()
                            }
                            composable(route = Screens.FeedScreen.route) {
                                FeedScreen()
                            }
                            composable(route = Screens.ProfileScreen.route) {
                                ProfileScreen()
                            }
                        }
                    }
                }


//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                  Column(modifier = Modifier
//                      .fillMaxSize()
//                      .padding(innerPadding)) {
//                      val viewModel:MainViewModel = viewModel()
//                      viewModel.fetchDataFromApi()
//                      val state = viewModel.fetchRecipe.value
//                      when{
//                          state.loading->{
//                              CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
//                          }
//                          state.error != null->{
//                                Text(state.error)
//                          }
//                          else->{
//                              Text(state.data.toString())
//                          }
//                      }


//                  }
//                }
            }
        }
    }
}

@Composable
fun Homepage(modifier: Modifier = Modifier) {

}


