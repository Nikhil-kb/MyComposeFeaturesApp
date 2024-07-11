package com.npav.myrvapp.enum

enum class ExEnum {

    RED, GREEN, VIOLET, GRAY, GREENHUE, CYAN, YELLOW;

    fun applyColor(colorId: Int): ExEnum{
        when(colorId){
            1 -> return GREEN

        }
        return valueOf("RED")
    }

}