package lectures.part1basic

object ValuesVariablesTypes extends App {

    val x: Int = 42
    //x = 2 VALS ARE IMMUTABLE
    // Type of val is optional. Compiler infers types i.e. val x = 42

    // semicolon is required if two expression are in the same line otherwise it can be avoided.

    val aString: String = "Scala"
    val aBoolean: Boolean = true //false
    val aChar: Char = 'a' //Notice the single quotes
    val aShort: Short = 12344 //Half of Int - 2 bytes
    val aLong: Long = 131234344L //8-byte Notice the ending L
    val aFloat: Float = 2.0f //f presents float otherwise it is considered double
    val aDouble: Double = 3.14

    //variables
    var aVariable: Int = 4
    aVariable = 5; // Mutable // Side Effects

    //scala prefers vals over vars


}
