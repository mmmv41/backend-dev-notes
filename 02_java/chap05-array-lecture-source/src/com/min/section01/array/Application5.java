package com.min.section01.array;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표 : 배열을 사용해 간단한 카드 뽑기 게임을 작성해보기 */
        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING", "ACE"};

        int randomShapeIndex = (int) (Math.random() * shape.length);    // 초기값은 0이기 때문에 + 0 을 생략해도됨.
        int randomNumberIndex = (int) (Math.random() * numbers.length);

        System.out.println("당신이 뽑은 카드는 " + shape[randomShapeIndex] + " "
                + numbers[randomNumberIndex] + "카드 입니다.");
        // shape[0], numbers[0] 이 뽑히면 -> SPADE 1 카드 입니다. 라고 출력
    }
}
