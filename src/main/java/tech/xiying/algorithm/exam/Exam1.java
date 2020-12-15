package tech.xiying.algorithm.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Exam1
 * @Description
 * @Author xiying
 * @Date 2020/12/14 21:22
 **/
public class Exam1 {

    /**
     * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
     * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
     * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     *
     * 输入描述:
     *  第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
     *  后面跟随N行，每行为一个待校验的字符串。
     *
     *输出描述:
     * N行，每行包括一个被修复后的字符串。
     *
     * 输入例子1:
     * 2
     * helloo
     * wooooooow
     * 
     * 输出例子1:
     * hello
     * woow
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordCount = scanner.nextInt();
        List<String> wordList = new ArrayList<>();
        for (int i=0;i<wordCount;i++){
            wordList.add(scanner.next());
        }

        if(wordList.size() > 0){
            List<StringBuffer> result = new ArrayList<>();
            wordList.forEach(word -> {
                StringBuffer wordBuffer = getResultBuffer(word);
                result.add(wordBuffer);
            });

            result.forEach(System.out::println);
        }
    }

    /**
     * 1. 每次删除字母后重新进行循环（删除后的String）
     *
     * 2. 最多循环 循环word - 2 次
     *
     * 将单词去除多余字母
     * @return
     */
    private static StringBuffer getResultBuffer(String word){
        StringBuffer result = new StringBuffer(word);
        Boolean endFlag = false;
        /**
         * 最多循环length-2 次
         */
        for(int i = 2; i < word.length() ;i++){

            if(!endFlag){
                /**
                 * 若有字符删除，删除字符重新进循环
                 */
                for(int j = 2; j < result.length(); j++){
                    // AAA 删除 第三个A
                    if(result.charAt(j) ==result.charAt(j-1) && result.charAt(j-1) ==result.charAt(j-2)){
                        result.deleteCharAt(j);
                        break;
                    }else{
                        // AABB 删除当前B
                        if((j+1) < result.length() && result.charAt(j) == result.charAt(j+1)
                                && result.charAt(j-1) ==result.charAt(j-2)){
                            result.deleteCharAt(j);
                            break;
                        }
                    }
                    // 全部遍历完毕说明已经不需要在循环
                    if(j == (result.length()-1)){
                        endFlag = true;
                    }
                }
            }
        }

        return result;
    }


}
