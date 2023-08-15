package com.olashiku.kmmtemplate.android.model

import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Strings

data class ProfileModel(
    val image: Int = R.drawable.edit_image_icon,
    val title: String = Strings.signUpText
) {
    fun getProfileModel(customerType: String): List<ProfileModel> {

        return when (customerType) {
            Strings.unRegisteredCustomerType -> {
                listOf(
                    ProfileModel(R.drawable.edit_image_icon, Strings.signUpText),
                    ProfileModel(R.drawable.payment_method_icon, Strings.loginString),
                    ProfileModel(R.drawable.support_icon, Strings.support)
                )
            }

            Strings.registeredCustomerType -> {
                listOf(
                    ProfileModel(R.drawable.edit_image_icon, Strings.editProfile),
                    ProfileModel(R.drawable.payment_method_icon, Strings.paymentMethod),
                    ProfileModel(R.drawable.address_icon, Strings.savedAddress),
                    ProfileModel(R.drawable.notification_icon, Strings.notification),
                    ProfileModel(R.drawable.support_icon, Strings.support),
                    ProfileModel(R.drawable.logout_icon, Strings.logout)
                )
            }

            else -> {
                listOf()
            }
        }
    }
}