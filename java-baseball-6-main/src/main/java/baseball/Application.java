package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            System.out.println("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞춰라!");
            playGame();
        } while (isContinue());
    }

    static void playGame() {
        String nums = resultNums();
        String[] scoreStr = {"스트라이크", "볼", "낫싱"};

        while (true) {
            System.out.println("서로 다른 3자리의 수를 적으시오!");
            String userInput = Console.readLine();

            if (!isTrue(userInput)) {
                continue;
            }

            int[] score = new int[3];

            String[] userNums = userInput.split("");
            for (int i = 0; i < nums.length(); i++) {
                String num = userNums[i];
                if (nums.contains(num)) {
                    if (nums.indexOf(num) == i) {
                        score[0]++;
                    } else {
                        score[1]++;
                    }
                } else {
                    score[2]++;
                }
            }
            if (score[2] == 3) {
                System.out.println(scoreStr[2]);
            } else {
                StringBuilder sb = new StringBuilder();
                if (score[1] != 0) {
                    sb.append(score[1]).append(scoreStr[1]).append(" ");
                }
                if (score[0] != 0) {
                    sb.append(score[0]).append(scoreStr[0]).append(" ");
                    if (score[0] == 3) {
                        sb.append('\n').append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println(sb);
                        break;
                    }
                }
                System.out.println(sb);
            }
        }
    }

    static String resultNums(){
        HashSet<Integer> randoms = new HashSet<>();
        while (randoms.size() < 3) {
            randoms.add(Randoms.pickNumberInRange(1, 9));
        }

        String nums = "";
        for (Integer num : randoms) {
            nums += String.valueOf(num);
        }
        return nums;
    }

    static boolean isTrue(String userInput){
        if (userInput.length() != 3) throw new IllegalArgumentException("3자리 숫자여야 합니다.");

        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 형식입니다.");
        }
    }
    static boolean isContinue() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return "1".equals(input);
    }
}
