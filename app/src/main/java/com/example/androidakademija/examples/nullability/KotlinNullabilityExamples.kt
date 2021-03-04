package com.example.androidakademija.examples.nullability

fun main() {
    val s1 = "abc"
    var s2: String? = null

    // this operator checks whether s2 is null, and runs the code only if it is not
    s2?.let {
        // s2 is null at this point, so this code will not run
        println("Print = $it")
    }

    if (s1.length < 10) {
        s2 = "def"
    }

    s2?.let {
        // s2 is no longer null at this point, so this will run
        println("Print = $it")
    }

    // used to change s2 back to null
    if (s1.length < 10) {
        s2 = null
    }

    // Elvis operator example, it acts as an if-else for checking the nullability
    val length = s2?.length ?: -1
    println("Length = $length")

    s2?.let {
        // s2 is null at this point, so this will not run
        println("Length = $it")
    }

    // This can not compile because the compiler knows that s2 can be null, comment it out and run afterwards
    println("Length = ${s2.length}}")
    // This is an example that can cause a Null Pointer Exception, run to see the effects
    println("Length = ${s2!!.length}}")
}