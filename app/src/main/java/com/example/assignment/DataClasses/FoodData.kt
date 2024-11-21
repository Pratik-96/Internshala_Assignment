package com.example.assignment.DataClasses

data class FoodData(
    val itemtype:String,
    val name:String,
    val health_rating:Int,
    val description:String,
    val generic_facts:List<String>,
    val similar_items:List<SimilarItems>,
    val nutrition_info:String,
)
data class NutritionInfo(
    val units: String,
    val name: String,
    val value: Double
)
data class Data(
    val data:FoodData
)


data class SimilarItems(
    val id:String,
    val name:String
)