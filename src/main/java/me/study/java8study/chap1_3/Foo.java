package me.study.java8study.chap1_3;

import me.study.java8study.chap1_2.Plus10;
import me.study.java8study.chap1_2.RunSomething;
import me.study.java8study.chap1_2.RunSomething2;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();

    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스, 익명 클래스, 람다의 공통점은 외부 변수를 참조할 수 있다.
        // final은 변경이 불가능함.
        // 로컬 클래스와 익명 클래스는 쉐도잉이 가능함, Foo 클래스 안에서 각 별도의 스코프를 가짐.

        //로컬 클래스
        class localCalss{
            void printBaseNumber(){
                int baseNumber = 11;
                // 11 찍힘
                // 안에서 선언한 baseNumber가 밖에서 선언한 baseNumber를 가림.
                // 익명 클래스도 마찬가지
                
                System.out.println(baseNumber);
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // 밖에서 선언한 baseNumber를 받지 않고 파라미터로 전달받은 값으로 처리
                System.out.println(baseNumber);
            }
        };

        //람다
        //람다는 밖에서 선언한 baseNumber 와 같은 스코프
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);

        printInt.accept(10);
    }
}
