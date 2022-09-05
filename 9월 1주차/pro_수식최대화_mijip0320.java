package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/67257
import java.util.*;

public class pro_수식최대화_mijip0320 {
    private static long max = 0;
    private static String expression;
    public static void main(String[] args) {
        expression = "100-200*300-500+20";
        long answer = 0;

        String[] expList = {"-" , "+", "*"};

        dfs(0,3,expList, new boolean[3], "");


        System.out.println(max);
    }

    public static void dfs(int start, int target, String[] expList, boolean[] check, String result){
        //연산자 3개 +, -, *로 만들 수 있는 순열은 [+, - , *], [+, *, -], [-, *, +], [-, +, *], [*, -, +], [*, +, -]으로 총 6개
        if(start == target){
            calc(result); //연산자 3개에 대한 우선순위가 정해졌을 때 계산 진행
        }else{
            for(int i=0; i<expList.length; i++){
                if(!check[i]){
                    check[i] = true;
                    dfs(start+1, target, expList, check, result+expList[i]);
                    check[i] = false;
                }
            }
        }
    }

    public static void calc(String op) { //계산 진행, op: "-+*" 형식으로 전달됨
        StringBuilder sb = new StringBuilder();
        List<Long> operandList = new LinkedList<>(); //숫자 받는 리스트
        List<String> operatorList = new LinkedList<>(); //연산자 받는 리스트

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                operandList.add(Long.parseLong(sb.toString())); //숫자 리스트에 받은 숫자 추가
                sb = new StringBuilder(); //숫자 초기화
                operatorList.add(String.valueOf(expression.charAt(i))); //연산자 추가
            } else sb.append(expression.charAt(i));
        }

            operandList.add(Long.parseLong((sb.toString())));


                for (int k = 0; k < 3; k++) {
                    String nowOperator = String.valueOf(op.charAt(k));

                    while (operatorList.size() != 0) {
                        int index = operatorList.indexOf(nowOperator);

                        if (index == -1)
                            break;
                        else {
                            switch (nowOperator) { //해당 연산자 실행
                                case "+":
                                    operandList.add(index, operandList.get(index) + operandList.get(index + 1));
                                    break;
                                case "-":
                                    operandList.add(index, operandList.get(index) - operandList.get(index + 1));
                                    break;
                                case "*":
                                    operandList.add(index, operandList.get(index) * operandList.get(index + 1));
                                    break;
                            }
                            //계산하고 기존에 존재했던 값들 제거
                            operandList.remove(index + 1);
                            operandList.remove(index + 1);
                            //사용한 연산자 제거
                            operatorList.remove(index);
                        }
                    }
                }

                max = Math.max(max, Math.abs(operandList.get(0))); //절댓값 중 max 값 추출, 저장
            }


}
