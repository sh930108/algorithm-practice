package tech.xiying.algorithm.common;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import tech.xiying.algorithm.entity.Node;

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
    public void testPre(){
        // 前置排序
        Node root = init();
        root.preOrder(root);
        List<Integer> dataList = root.getDataList();
        System.out.println(gson.toJson(dataList));
        // 中置排序
        Node root1 = init();
        root1.midOrder(root1);
        List<Integer> dataList1 = root1.getDataList();
        System.out.println(gson.toJson(dataList1));
        // 后置排序
        Node root2 = init();
        root2.postPositionOrder(root2);
        List<Integer> dataList2 = root2.getDataList();
        System.out.println(gson.toJson(dataList2));
    }

    @Test
    public void maxDeepTest(){
        Node root = init();
        int maxDeep = root.maxDeep(root);
        System.out.println(maxDeep);
    }

    @Test
    public void minDeepTest(){
        Node root = init();
        int minDeep = root.minDeep(root);
        System.out.println(minDeep);
    }

    @Test
    public void sumLeafTest(){
        Node root = init();
        root.sumLeaf(root);
        System.out.println(root.getLeafSum());
        int i = root.sumLeafMethodII(root);
        System.out.println(i);
    }

    @Test
    public void getLevelSumTest(){
        Node root = init();
        root.getLevelSum(root,4,1);
        System.out.println(root.getLevelSum());
    }

    @Test
    public void getAllRoadTest(){
        Node root = init();
        root.getAllRoad(root,null);
        System.out.println(root.getRoadList());
    }

    @Test
    public void getTreeWidthTest(){
        Node deepNode = init();
        int maxDeep = deepNode.maxDeep(deepNode);

        Integer maxWidth = 0;
        for(int i=1;i<=maxDeep;i++){
            Node root = init();
            root.getTreeWidth(root, 1, i);
            if(maxWidth < root.getTreeWidth()){
                maxWidth = root.getTreeWidth();
            }
            System.out.println(root.getTreeWidth());
        }
        System.out.println("========"+ maxWidth);
    }

    /**
     *                     a(10)
     *               b(5)        c(4)
     *           d(3)               e(11)
     *              f(7)        g(12)   h(15)
     *            k(8)
     * @return
     */
    private Node init(){
        // 第5层
        Node k = new Node(8,null,null);

        // 第4层
        Node f = new Node(7,k,null);
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

    @Test
    public void test(){
        String s= "index";
        char c = s.charAt(0);
        System.out.println(c);
    }
}
