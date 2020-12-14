package tech.xiying.algorithm.exam;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Exam1
 * @Description
 * @Author shanghao5
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
        List<String> wordList = Lists.newArrayList();
        for (int i=0;i<wordCount;i++){
            wordList.add(scanner.next());
        }

        if(!CollectionUtils.isEmpty(wordList)){
            List<StringBuffer> result = Lists.newArrayList();
            wordList.forEach(word -> {
                StringBuffer wordBuffer = new StringBuffer(word);
                for(int i= 0;i< word.length();i++){
                    char a = word.charAt(i);
                    if((i+1) < word.length()){
                        char b = word.charAt(i+1);
                        if(a == b){
                            if((i+2) < word.length()){
                                char c = word.charAt(i+2);
                                if(a == c){
                                    wordBuffer.deleteCharAt(i);
                                }else{
                                    if((i+3) < word.length()){
                                        char d = word.charAt(i+3);
                                        if (c == d) {
                                            wordBuffer.deleteCharAt(i+3);
                                        }
                                    }


                                }
                            }
                        }
                    }
                }
                result.add(wordBuffer);
            });

            result.forEach(System.out::println);

        }



    }




}
