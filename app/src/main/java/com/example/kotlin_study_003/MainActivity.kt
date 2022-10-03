package com.example.kotlin_study_003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

/*
확장 함수 extension function
상송하기 않고 클래스 외부에서 멤버함수를 추가하는 기능
String 클래스는 open 키워드가 붙어있지 않다.
따라서 상석을 받을 수 없다.
멤버함수를 추가할 수가 없다.
코틀린 내장된 클래스는 사용자가 마음대로 멤버함수를 추가할 수 없다.

확장 함수를 이용하면 상속 없이 클래스 외부에서 멤버함수를 추가할 수 있다.
 */

// 문자열이 숫자로만 이루어져 있는지 판단하는 함수
fun String.isNumber(): Boolean {
    var i = 0
    while (i < this.length) {
        if (!(this[i] in '0'..'9')) {
            return false
        }
        i += 1
    }
    return true
}

/*
확장 프로퍼티 extension property
확장 프로퍼티에는 field 가 존재하지 않는다.
 */

var j = 0
val String.isLongLength: Boolean
    get() = this.length >= 5

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("hsson", "isNumber() = ${"12345".isNumber()}")
        // result : true
        Log.i("hsson", "isNumber() = ${"123사오".isNumber()}")
        // result : false

        Log.i("hsson", "isLongLength() = ${"1234567".isLongLength}")
        // result : true
        Log.i("hsson", "isLongLength() = ${"123".isLongLength}")
        // result : false
    }
}