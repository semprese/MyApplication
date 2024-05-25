package com.bignerdranch.android.myapplication

class Pizza(name_:String, val res:Int) {
    var name = name_
        private set
    companion object{
        val pizzas = arrayOf(
            Pizza("Diavolo", R.drawable.diavolo),
            Pizza("Funghi", R.drawable.funghi)
        )
    }
}