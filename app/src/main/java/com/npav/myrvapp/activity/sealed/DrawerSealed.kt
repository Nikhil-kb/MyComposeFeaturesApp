package com.npav.myrvapp.activity.sealed

sealed class DrawerSealed(val title: String, val route: String){

    object Home: DrawerSealed("Home", "home")
    object Account: DrawerSealed("Account", "account")
    object Help: DrawerSealed("Help", "help")

}
