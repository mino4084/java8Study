package me.study.java8study.chap1_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class App {
    public static void main(String[] args) {

        //UnaryOperator<String> hi = (s) -> "hi" + s;
        //:: 메소드 레퍼런스
        
        // 스태틱 메소드 레퍼런스
        UnaryOperator<String> hi = Greeting::hi;

        // 인스턴스 메소드 레퍼런스
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        // hello 자체는 그저 UnaryOperator 일뿐.
        // apply를 해야만 hello 메소드 실행
        System.out.println(hello.apply("mino"));

        // 생성자는 입력 값은 없는데 리턴 값은 있다
        // 맞는 함수형 인터페이스는 Supplier
        Supplier<Greeting> greetingSupplier = Greeting::new;

        // greetingSupplier -> 자체는 인스턴스를 만든 것이 아니다
        // 단순히 greetingSupplier 이고 Greeting이 아니다

        // get 해야만 인스턴스 생성
        greetingSupplier.get();

        // 입력 값 있고 리턴 값도 있는 함수형 인터페이스
        // Function
        Function<String, Greeting> stringGreetingFunction = Greeting::new;

        Greeting greeting1 = stringGreetingFunction.apply("mino");
        System.out.println(greeting1.getName());

        // 임의 객체 인스턴스 메소드
        String[] names = {"mino1", "mino2", "mino3"};
        // Comparator -> java 8는 함수형 인터페이스
        /*
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
         */
        //Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);
        //compareToIgnoreCase가 배열 값들의 임의의 객체를 받으면서 메소드 실행.

        System.out.println(Arrays.toString(names));
    }
}
