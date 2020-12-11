package tech.xiying.algorithm.node;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName Node
 * @Description
 * @Author shanghao5
 * @Date 2020/12/11 14:32
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    private int data;
    private Node left;
    private Node right;

    private List<Integer> dataList = Lists.newArrayList();

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void preOrder(Node root){
        if(root != null){
            dataList.add(root.getData());
            if(Objects.nonNull(root.left)){
                // 递归左子树
                preOrder(root.left);
            }
            if(Objects.nonNull(root.right)){
                // 递归右子树
                preOrder(root.right);
            }
        }
    }

}
