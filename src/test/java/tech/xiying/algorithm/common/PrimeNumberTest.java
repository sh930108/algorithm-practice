package tech.xiying.algorithm.common;


import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import tech.xiying.algorithm.utils.PrimeNumberUtil;

import java.util.List;

/**
 * @ClassName PrimeNumberTest
 * @Description
 * @Author shanghao5
 * @Date 2020/12/10 15:37
 **/
public class PrimeNumberTest {

    private final Gson gson = new Gson();

    @Test
    public void test1(){
        /**
         * 题目1 : 获取 1 - 10000 所有质数
         */
        List<Integer> list = PrimeNumberUtil.obtainPrimeNumber(7);
        System.out.println(gson.toJson(list));
    }

    @Test
    public void test2(){
        /***
         * 题目二 : 因式分解
         *
         * 1. 获取小于等于输入数的质数列；
         *
         * 2. 进行质数分解，分解一个重新分解，直到分解完成；
         */
        int num = 224;
        List<Integer> list = PrimeNumberUtil.obtainPrimeNumber(num);

        List<Integer> childList = Lists.newArrayList();

        int temp = num;
        while ( temp > 1 ){
            temp = getTempNum(temp, list, childList);
        }
        System.out.println("质数列："+gson.toJson(list));
        System.out.println("公因式："+gson.toJson(childList));
    }

    /**
     * 获取分解一个因式之后的值
     * @return
     */
    private Integer getTempNum(Integer num,List<Integer> primeList,List<Integer> childList){
        Integer temp = null;
        for (Integer prime : primeList){
            if(num % prime == 0){
                temp = num / prime;
                childList.add(prime);
                break;
            }
        }
        return temp;
    }

}
