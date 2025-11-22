package org.example;

import org.example.service.Bus;
import org.example.service.Car;
import org.example.service.KTX;
import org.example.service.Transformation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    public static void main(String[] args) {

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("거리는 몇 km입니까?");
            int distance = Integer.parseInt(scanner.nextLine());
            System.out.println("교통수단을 선택하세요.1.자동차 2. KTX 3.고속버스 ");
            String trans = scanner.nextLine();

            Map<String, Transformation> transeformationHashMap = new HashMap<String, Transformation>();

            transeformationHashMap.put("1", new Car(distance));
            transeformationHashMap.put("2", new KTX(distance));
            transeformationHashMap.put("3", new Bus(distance));

            Transformation result = transeformationHashMap.get(trans);

            System.out.println(result.feeCalc());
        }


    }
}