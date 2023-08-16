package com.olashiku.kmmtemplate.android.resource

object Strings {

    /** text resource*/
    const val introText = "Delicious flavors, endless choices, Burga Boss reigns supreme. Order, indulge, savor every bite, convenience at your fingertips."
    const val loginText = "Log in"
    const val login = "Login"
    const val signInWithGoogle = "Sign in with Google"
    const val emailOrPhoneText = "Enter your email or phone number"
    const val passwordText = "Enter your password"
    const val rememberMeText ="Remember me"
    const val getStarted = "Get Started"
    const val signupText = "Sign Up"
    const val orText = "OR"
    const val exploreText = "Explore without onboarding"
    const val forgotPassword = "Forgot Password?"
    const val noAccountTextOne = "Don’t have an account?"
    const val haveAccountLogin = "Already have an account?"
    const val noOrders = "No order available"
    const val noFavorite = "You have nothing in My favourites"
    const val noAccountTextTwo = " Sign Up"

    const val outsideRoot = "outsideRoot"
    const val insideRoot = "insideRoot"

    /** registration resource*/
    const val firstNameText = "Enter your first name"
    const val lastNameText = "Enter your last name"
    const val emailText = "Enter your email "
    const val phoneText = "Enter your phone number"
    const val confirmPasswordText = "Confirm your password"

     /**Otp  Screen Resource*/
    const val verificationTitle = "Verification"
    const val verificationBody = "Enter the OTP that was sent to your email/phone number "
    const val proceed = "Proceed"

    /**Success  Screen Resource*/
    const val successTitle = "Sign Up Successful"
    const val successBody = "You have successfully signed up to Burger Boss. Dive into placing your orders."

    /** route resource*/
    const val splashScreen = "SplashScreen"
    const val introScreen = "IntroScreen"
    const val loginScreen = "LoginScreen"
    const val registrationScreen = "RegistrationScreen"
    const val dashboardScreen  = "DashboardScreen"
    const val otpScreen = "otpScreen"
    const val verificationScreen = "VerificationScreen"
    const val successScreen = "SuccessScreen"

    /**menu route resource*/
    const val menuScreen = "MenuScreen"
    const val myOrderScreen = "MyOrderScreen"
    const val myFavoriteScreen = "MyFavoriteScreen"
    const val myProfileScreen = "MyProfileScreen"

    /**customer type resource*/
    const val registeredCustomerType = "registered"
    const val unRegisteredCustomerType = "unregistered"



    /**menu text resource*/
    const val menu = "Menu"
    const val order = "My Order"
    const val favorite = "My Favorite"
    const val profile = "My Profile"


    /**profile unregistered user resource*/
    const val signUpText = "Sign up"
    const val loginString = "Login"
    const val support = "Support"

    /**profile registered user resource*/
    const val editProfile = "Edit profile"
    const val paymentMethod = "Payment method"
    const val savedAddress = "Saved Address"
    const val notification = "Notification"
    const val changePassword = "Change password"
    const val logout = "Logout"


    const val burger = "Burger"
    const val fries = "Fries"
    const val drinks = "Drinks"

    fun getTabCategory():List<String>{
        return listOf("Burger", "Fries", "Drinks")
    }





}