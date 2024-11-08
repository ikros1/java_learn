package java_se.value_or_reference_safe_example;

import java.util.Arrays;
//https://www.ikaros.love/?p=606

public class Main {
    public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        ScoreSafe ss = new ScoreSafe(scores);
        s.printScores();
        ss.printScores();
        scores[2] = 99;
        s.printScores();
        ss.printScores();
        //这种将外部引用类型直接传递给实例后修改外部的值导致不使用实例的字段修改方法就改变是危险的
        //得使用复制一份新的数据来保证数据的独立性

    }
}

class Score {
    private int[] scores;
    public Score(int[] scores) {
        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}

class ScoreSafe {
    private int[] scores;
    public ScoreSafe(int[] scores) {
        this.scores = scores.clone();
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}