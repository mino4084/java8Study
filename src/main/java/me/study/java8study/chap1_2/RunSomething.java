package me.study.java8study.chap1_2;

@FunctionalInterface
public interface RunSomething {
    // 함수형 인터페이스
    // 함수형 인터페이스 안에 추상메소드는 1개이어야 한다.
    // 다른 형태의 메소드 타입의 갯수는 상관없다
    // 자바가 @FunctionalInteface 어노테이션 지원 -> 함수형 인터페이스 정의
    // 컴파일 시 위반 확인

    //추상메소드
    //abstract void doIt();
    //추상메소드에 붙는 abstract는 생략 가능
    void doIt();

    //Java8부터 인터페이스 안에 스태틱 메소드 사용 가능
    //public 생략 가능
    public static void printName(){
        System.out.println("minho");
    }

    default void printAge(){
        System.out.println("31");
    }

}
