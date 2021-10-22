package ge.nlatsabidze.retrofitexample


import com.google.gson.annotations.SerializedName
import ge.nlatsabidze.retrofitexample.Content

data class Constants(
    @SerializedName("content")
    val content: List<Content>
)