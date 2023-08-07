package Lotto;

import java.util.*;

public class Lotto_bot {
    Random rand = new Random();
    private int num_lotto;
    protected int count;
    Set<Integer> center_numbers = new HashSet();

    //맞은 번호들

    public Lotto_bot(int num_lotto){
        this.num_lotto = num_lotto;
    }

    public Set<Integer> num_generator(){
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() != 6){
            numbers.add(rand.nextInt(46)+1);
        }return numbers;
    }

    public int compare(Set<Integer> center_numbers, Set<Integer> buyer_numbers ) {
        int count =0;
        ArrayList<Integer> winning =new ArrayList<>();
        for (Integer center_number : center_numbers) {
            for (Integer buyer_number : buyer_numbers) {
                if (center_number == buyer_number) {
                    //맞는 번호
                    winning.add(center_number);
                    count++;
                }
            }
        }
        System.out.print(" winning = " + winning);
        return count;
    }
    public void result(int count){
        if(count == 6){
            System.out.print(" 1등입니다.\n");
        }else if(count == 5){
            System.out.print(" 2등입니다.\n");
        }else if(count == 4){
            System.out.print(" 3등입니다.\n");
        }else if(count == 3){
            System.out.print(" 4등입니다.\n");
        }else{
            System.out.print(" 꽝입니다.\n");
        }
    }
}
