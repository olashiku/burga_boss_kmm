package com.olashiku.kmmtemplate.model

data class ProductDetails(
    val productName: String = "",
    val productDescription: String = "",
    val amount: String = ""
) {
    fun getProducts(): List<ProductDetails> {
        return listOf(
            // ₦1,000.00
            ProductDetails(
                "Double Grilled Chicken",
                "this is a double grilled chicken",
                "₦1,000.00"
            ),
            ProductDetails("Double Beef Burger", "this is a double grilled chicken", "₦2,000.00"),
            ProductDetails(
                "Double Crunchy Burger",
                "this is a double grilled chicken",
                "₦3,000.00"
            ),
            ProductDetails(
                "Single Crunchy Burger",
                "this is a double grilled chicken",
                "₦3,000.00"
            ),

            ProductDetails(
                "Double Crunchy Burger",
                "this is a double grilled chicken",
                "₦3,000.00"
            ),
            ProductDetails(
                "Single Crunchy Burger",
                "this is a double grilled chicken",
                "₦3,000.00"
            ),

            ProductDetails(
                "Double Crunchy Burger",
                "this is a double grilled chicken",
                "₦3,000.00"
            ),
            ProductDetails(
                "Single Crunchy Burger",
                "this is a double grilled chicken",
                "₦3,000.00"
            )

        )
    }
}

