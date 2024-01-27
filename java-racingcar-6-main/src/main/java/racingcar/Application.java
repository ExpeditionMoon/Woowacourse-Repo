package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carList = carList();
        int time = time();

        String[] go = new String[carList.length];
        for (int i = 0; i < time; i++) {
            go = goStop(go);
            for (int j = 0; j < carList.length; j++) {
                System.out.println(carList[j] + " : " + go[j]);
            }
            System.out.println();
        }

        String[] win = winner(carList, go).split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < win.length; i++) {
            sb.append(win[i]);
            if (i < win.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

    static String[] carList() {
        System.out.println("경주 할 자동차 이름을 쉼표(,)를 기준으로 구분하여 입력하세요.");
        String carName = Console.readLine();
        return carName.split(",");
    }

    static int time() {
        System.out.println("경주 시도 횟수를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    static String[] goStop(String[] go) {
        for (int i = 0; i < go.length; i++) {
            if (go[i] == null) {
                go[i] = "";
            }

            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                go[i] += "-";
            }
        }
        return go;
    }

    static String winner(String[] carList, String[] go) {
        int max = 0;
        int[] goTime = new int[carList.length];

        for (int i = 0; i < go.length; i++) {
            int len = go[i].length();
            goTime[i] = len;

            if (len >= max) {
                max = len;
            }
        }

        String win = "";
        for (int i = 0; i < goTime.length; i++) {
            if (goTime[i] == max) {
                win += carList[i] + " ";
            }
        }
        return win;
    }
}
