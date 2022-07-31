package me.study.java8study;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymonus inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello.");
            }
        };

        runSomething.doIt();
        
        //람다형
        /*
        RunSomething runSomething = () -> System.out.println("Lambda");
         */

        /*
        RunSomething2 runSomething2 = (number) -> {
            return number + 10;
        };
         */
        RunSomething2 runSomething2 = (number) -> number + 10;

        System.out.println(runSomething2.doit(1));
        System.out.println(runSomething2.doit(1));
        System.out.println(runSomething2.doit(1));

        System.out.println(runSomething2.doit(2));
        System.out.println(runSomething2.doit(2));


        /////////////////////////////////////////////////////////

        Plus10 plus10 = new Plus10();
        plus10.apply(1);
        System.out.println(plus10.apply(1));

        // Function<T, R>
        // T 타입 유형으로 받아 R 타입으로 리턴
        Function<Integer, Integer> plus11 = (i) -> i + 11;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        // default method
        // compose
        // 매개변수로 받은 multiply2 함수가 먼저 실행
        plus11.compose(multiply2);

        Function<Integer, Integer> multiply2AndPlus11 = plus11.compose(multiply2);
        System.out.println("compose : " + multiply2AndPlus11.apply(2));

        // default method
        // andThen
        plus11.andThen(multiply2);
        System.out.println("andThen : " + plus11.andThen(multiply2).apply(2));

        // BiFunction<T, U, R>
        // 두 개의 값 T, U을 받아서 R 리턴
        // 입력 값 2개, 반환 값 1개

        // Consumer<T>
        Consumer<Integer> printInt = (i) -> System.out.println("consume : " + i);
        printInt.accept(10);

        // Supplier<T>
        Supplier<Integer> get10 = () -> 10;
        System.out.println("supplier : " + get10.get());

        // Predicate<T>
        Predicate<String> startsWithMino = (str) -> str.startsWith("mino");
        Predicate<Integer> isEven = (i) -> (i % 2) == 0;
        Predicate<Integer> isOdd = (i) -> (i % 2) == 1;

        System.out.println("predicate startswithMino :" + startsWithMino.test("kyobo"));
        System.out.println("predicate startswithMino :" + startsWithMino.test("mino kyobo"));
        System.out.println("predicate even :" + isEven.and(isOdd).test(4));

        // UnaryOperator
        // 입력값과 반환값의 타입이 동일한 경우
        // Function<T>을 상속받음
        UnaryOperator<Integer> plus12 = (i) -> i + 12;

        // BinaryOperator<T>
        // 입력값 2개와 반환값 1개의 타입이 동일한 경우
        // BiFunction<T, U, R> 상속 받음

    }
}
