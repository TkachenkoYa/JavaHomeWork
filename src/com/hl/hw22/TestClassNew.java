package com.hl.hw22;

public class TestClassNew {
    @BeforeSuite
    void setUp() {
        System.out.println("New setUp method");
    }

    @Test
    public void method() {
        System.out.println("Null");
    }

    @Test(order = 1)
    public void method1() {
        System.out.println("Second");
    }

    @Test(order = 2)
    public void method2() {
        System.out.println("First");
    }

    @Test(order = 3)
    public void method3() {
        System.out.println("Four");
    }

    @Test(order = 4)
    public void method4() {
        System.out.println("Third");
    }

    @AfterSuite
    void tearDown() {
        System.out.println("Tear down method");
    }
}
