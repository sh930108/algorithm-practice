package tech.xiying.algorithm.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 质数
 *
 * @ClassName utils
 * @Description
 * @Author shanghao5
 * @Date 2020/12/10 16:11
 **/
public class PrimeNumberUtil {

    /**
     * 获取小于 boundary 所有质数
     *
     * @param boundary
     * @return
     */
    public static List<Integer> obtainPrimeNumber(Integer boundary){
        List<Integer> primeList = Lists.newArrayList();

        for(int i=2;i<=boundary;i++){
            // 若为偶数直接下一个
            if(i % 2 == 0 && i != 2){
                continue;
            }
            boolean primeFlag = true;
            // 判断除到自身开方即可
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    primeFlag = false;
                    break;
                }
            }
            // 质数添加
            if(primeFlag){
                primeList.add(i);
            }
        }
        return primeList;
    }

}
