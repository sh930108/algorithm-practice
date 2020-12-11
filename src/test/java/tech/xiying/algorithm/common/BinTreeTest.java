package tech.xiying.algorithm.common;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import tech.xiying.algorithm.node.Node;

import java.util.List;

/**
 * @ClassName BinTreeTest
 * @Description
 * @Author shanghao5
 * @Date 2020/12/11 20:54
 **/
public class BinTreeTest {

    private final Gson gson = new Gson();

    @Test
    public void test1(){
        Node root = init();
        root.preOrder(root);
        List<Integer> dataList = root.getDataList();
        System.out.println(gson.toJson(dataList));
    }

    private Node init(){
        // 第4层
        Node f = new Node(7,null,null);
        Node g = new Node(12,null,null);
        Node h = new Node(15,null,null);
        // 第3层
        Node d = new Node(3,null,f);
        Node e = new Node(11,g,h);
        // 第2层
        Node b = new Node(5,d,null);
        Node c = new Node(4,null,e);
        // 第1层
        Node a = new Node(10,b,c);
        return a;
    }

}
