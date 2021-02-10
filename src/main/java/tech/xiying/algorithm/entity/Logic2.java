package tech.xiying.algorithm.entity;

import java.util.Stack;

public class Logic2 {

    public static void main(String[] args) {
        int[] arr = new int[]{69,75,71,91,73,81};
        int[] ints = dailyTemperatures(arr);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]+ " ");
        }
    }

    /**
     * 单调栈解决天气问题
     *
     * 69 70 80 91 71 68
     * 后面几天会超过前面的温度
     *
     */
    private static int[] dailyTemperatures(int[] temp){
        int[] ans = new int[temp.length];
        Stack<Integer> stack = new Stack<>();

        // 遍历
        for(int i=0; i < temp.length ;i++){
            // 若后一天的天气大于栈顶元素，则栈顶元素弹出
            while(!stack.empty() && temp[i] > temp[stack.peek()]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return  ans;
    }
}
