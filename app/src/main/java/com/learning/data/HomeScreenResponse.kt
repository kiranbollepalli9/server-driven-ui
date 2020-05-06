package com.learning.data

import com.google.gson.annotations.SerializedName

data class HomeScreenResponse(val data: List<Item>) {
    data class Item (
        val viewType: ItemViewType,
        val header: Header?,
        val data: List<SubItem>
    ) {
        data class Header(
            val title: String,
            val hasMore: Boolean
        )
        data class SubItem(
            val id : String,
            val viewType: SubItemViewType,
            val imageUrl: String,
            val title: String?,
            val action: HomeScreenAction
        )
    }
    data class HomeScreenAction(
        val type: String,
        val value: String
    )

    enum class ItemViewType {
        @SerializedName("horizontalScroll") HorizontalScroll
       // @SerializedName("verticalScroll") VerticalScroll
    }

    enum class SubItemViewType {
        @SerializedName("carouselElement") Carousel,
        @SerializedName("cardElement") Card
        //@SerializedName("restaurantElement") Restaurant
    }

}