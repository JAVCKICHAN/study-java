package org.example.exception;

import java.util.Scanner;

//1月22日
public class Exception1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("나이를 입력하세요");

        try {
            int num = Integer.parseInt(scanner.nextLine());
            System.out.println(num);
            System.out.println("-----------------------");
        }catch (Exception e){ //Exception 타입 - 추상화된 코드. 하위 예외 모두 들어올 수 있음.
            System.out.println();
        }

    }
}
