package com.hl.hw22;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestRunner implements SuperTestClass {
    public static void start(String className) {
        try {
            start(Class.forName("com.hl.hw22."+className));
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }
    public static void start(Class<?> testClass) {
        try {
            List<Method> setUpMethods = Arrays.stream(testClass.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                    .toList();
            if (setUpMethods.size() > 1) {
                throw new RuntimeException("BeforeSuite annotation must be a single");
            }
            List<Method> tearDownMethods = Arrays.stream(testClass.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                    .toList();
            Object testObject = testClass.getConstructor().newInstance();
            if (setUpMethods.size() == 1) setUpMethods.get(0).invoke(testObject);

            List<Method> testMethods = Arrays.stream(testClass.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(Test.class))
                    .sorted(Comparator.comparingInt(o -> o.getAnnotation(Test.class).order()))
                    .toList();

            for (Method method : testMethods) {
                method.invoke(testObject);
            }
            if (tearDownMethods.size() == 1) tearDownMethods.get(0).invoke(testObject);
            if (tearDownMethods.size() > 1) {
                throw new RuntimeException("AfterSuite annotation must be a single");
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException |RuntimeException e) {
            e.getMessage();
        }
    }
}
