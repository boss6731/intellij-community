public class Main {
    static interface A
    {
        interface B  { }
    }

    static class D implements A
    {
        private interface B { }
    }


    static class C extends D implements A
    {
        interface E extends B { }
        interface E1 extends D.B { }
        interface E2 extends A.B { }
    }

}



class Main1 {
    static interface A
    {
        interface B  { }
    }

    static class D implements A
    {
        interface B { }
    }


    static class C extends D implements A
    {
        interface E extends <error descr="Reference to 'B' is ambiguous, both 'Main1.D.B' and 'Main1.A.B' match">B</error> { }
        interface E1 extends D.B {
        }
        interface E2 extends A.B { }
    }

}


interface A
{
    interface B  { }
    interface B1  { }
}

class D implements A
{
    private interface B { }
    interface B1 { }
}


class C extends D implements A
{
    interface E extends B { }
    interface E1 extends D.<error descr="'D.B' has private access in 'D'">B</error> { }
    interface E2 extends A.B { }

    interface F extends <error descr="Reference to 'B1' is ambiguous, both 'D.B1' and 'A.B1' match">B1</error> { }
    interface F1 extends D.B1 { }
    interface F2 extends A.B1 { }

}
