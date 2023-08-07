package Lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Run_Lotto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("로또를 몇개 생성하시겠습니까?");
        int num_lotto = scan.nextInt();
        Lotto_bot lottoBot = new Lotto_bot(num_lotto);

        System.out.print("당첨 번호는: ");
        Set<Integer> Lottery_num = lottoBot.num_generator();
        System.out.println(Lottery_num);
        System.out.print("========================================\n");

        for(int i=0; i<num_lotto;i++) {
            System.out.print((i + 1) + "번째 로또 뽑기: ");
            Set<Integer>lotto_num = lottoBot.num_generator();
            System.out.print(lotto_num);
            int result = lottoBot.compare(Lottery_num, lotto_num);
            lottoBot.result(result);
        }
    }
}

