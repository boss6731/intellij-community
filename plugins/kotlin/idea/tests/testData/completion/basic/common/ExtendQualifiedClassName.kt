package Test.SubTest.AnotherTest

open class TestClass {
}

fun globalFun(){}
val globalProp: Int = 1

class A() : Test.SubTest.AnotherTest.Te<caret> {
    public fun test() {
    }
}

// EXIST: TestClass
// ABSENT: globalFun
// ABSENT: globalProp
