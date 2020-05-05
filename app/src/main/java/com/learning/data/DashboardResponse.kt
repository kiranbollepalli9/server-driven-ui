package com.learning.data

import com.google.gson.annotations.SerializedName

data class DashboardResponse( val data: List<Item>) {
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
            val viewType: SubItemViewType,
            val imageUrl: String,
            val title: String?,
            val subTitle: String?,
            val action: DashboardAction,
            val meta: Meta?
        ) {
            data class Meta(
                val bgColor: String?,
                val rating: String?,
                val reviewCount: String?,
                val hasFreeDelivery: Boolean
            )
        }
    }
    data class DashboardAction(
        val type: String,
        val value: String
    )

    enum class ItemViewType {
        @SerializedName("horizontalScroll") HorizontalScroll,
        @SerializedName("verticalScroll") VerticalScroll
    }

    enum class SubItemViewType {
        @SerializedName("bannerElement") Banner,
        @SerializedName("categoryElement") Category,
        @SerializedName("restaurantElement") Restaurant
    }

}