package ge.nlatsabidze.retrofitexample


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("category")
    val category: String,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("descriptionEN")
    val descriptionEN: String,
    @SerializedName("descriptionKA")
    val descriptionKA: String,
    @SerializedName("descriptionRU")
    val descriptionRU: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("isLast")
    val isLast: Boolean,
    @SerializedName("publish_date")
    val publishDate: String,
    @SerializedName("published")
    val published: Int,
    @SerializedName("titleEN")
    val titleEN: String,
    @SerializedName("titleKA")
    val titleKA: String,
    @SerializedName("titleRU")
    val titleRU: String,
    @SerializedName("updated_at")
    val updatedAt: Long
)