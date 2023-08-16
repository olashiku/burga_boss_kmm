package com.olashiku.kmmtemplate.model

import com.olashiku.kmmtemplate.android.resource.Strings

data class ProductDetails(
    val productName: String = "",
    val productDescription: String = "",
    val amount: String = "",
    val category: String = ""
) {
    fun getProducts(): List<ProductDetails> {
        return listOf(
            ProductDetails(
                "Double",
                "this is a double grilled chicken",
                "₦1,000.00",Strings.burger
            ),
            ProductDetails("Double Beef Burger", "this is a double grilled chicken", "₦2,000.00"),
            ProductDetails(
                "Double",
                "this is a double grilled chicken",
                "₦3,000.00", Strings.burger
            ),
            ProductDetails(
                "Double",
                "this is a double grilled chicken",
                "₦3,000.00",Strings.burger
            ),

            ProductDetails(
                "Crunchy",
                "this is a double grilled chicken",
                "₦3,000.00",Strings.fries
            ),
            ProductDetails(
                "Crunchy",
                "this is a double grilled chicken",
                "₦3,000.00",Strings.fries
            ),

            ProductDetails(
                "Double Crunchy",
                "this is a double grilled chicken",
                "₦3,000.00",Strings.drinks
            ),
            ProductDetails(
                "Double Crunchy",
                "this is a double grilled chicken",
                "₦3,000.00",Strings.drinks
            )

        )
    }
}

