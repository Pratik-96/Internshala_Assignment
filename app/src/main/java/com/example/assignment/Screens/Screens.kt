package com.example.assignment.Screens

sealed class Screens(val route:String){
    object ActivityScreen : Screens("ActivityScreen")
    object GoalsScreen : Screens("GoalsScreen")
    object CameraScreen : Screens("CameraScreen")
    object FeedScreen : Screens("FeedScreen")
    object ProfileScreen : Screens("ProfileScreen")

}