package tech.xiying.algorithm.entity;

import com.google.common.base.Splitter;
import com.google.gson.Gson;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Logic {

//    public static void main(String[] args) {
//        System.out.println("请输入字符串：");
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//
//        Splitter splitter = Splitter.on(",");
//
//        List<String> stringList = splitter.splitToList(next);
//
//        if(stringList != null && stringList.size() > 0){
//           String lastString = stringList.get(stringList.size() - 1);
//            System.out.println(lastString+"-长度：" + lastString.length());
//        }
//
//        System.out.println(next);
//    }

    /**
     * 冒泡排序
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入逗号隔开字符串：");
        String next = scanner.next();
        Splitter splitter = Splitter.on(",");
//        String[] split = next.split(",");
        List<String> stringList = splitter.splitToList(next);
        List<Integer> integerList = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        Integer[] intList = new Integer[integerList.size()];
        integerList.toArray(intList);

        System.out.println("输入为："+ new Gson().toJson(stringList));

        // 循环次数（多少个元素循环多少次）
        for(int i = 0; i < integerList.size(); i++){
            // 每个元素的比较次数
            for(int j = 0; j < integerList.size() - i; j++){
                if(intList[i] > intList[i+j]){
                    int temp = intList[i];
                    intList[i] = intList[i+j];
                    intList[i+j] = temp;
                }
            }
        }
        System.out.println(new Gson().toJson(intList));
    }

}
