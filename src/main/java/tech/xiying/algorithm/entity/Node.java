package tech.xiying.algorithm.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 二叉树
 *
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


    /*********** 结果集 *************/

    private List<Integer> dataList = Lists.newArrayList();

    private Integer leafSum=0;

    private Integer levelSum=0;

    /**
     * 路径list
     */
    private List<String> roadList = Lists.newArrayList();
    /**
     * 宽度
     */
    private Integer treeWidth = 0;
    private Integer tempWidth;
    /*********** 结果集 *************/

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * 前置排序
     * @param root
     */
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

    /**
     * 前置排序
     * @param root
     */
    public void midOrder(Node root){
        if(root != null){
            // 递归左子树
            midOrder(root.left);
            dataList.add(root.getData());
            // 递归右子树
            midOrder(root.right);
        }
    }

    /**
     * 前置排序
     * @param root
     */
    public void postPositionOrder(Node root){
        if(root != null){
            if(Objects.nonNull(root.left)){
                // 递归左子树
                postPositionOrder(root.left);
            }
            if(Objects.nonNull(root.right)){
                // 递归右子树
                postPositionOrder(root.right);
            }
            dataList.add(root.getData());
        }
    }

    /**
     * 求二叉树最大深度
     *
     * @param root
     * @return
     */
    public int maxDeep(Node root){
        if(root == null){
            return 0;
        }
        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);

        return leftDeep > rightDeep ? leftDeep+1:rightDeep+1;
    }

    /**
     * 求二叉树最小深度
     *
     * @param root
     * @return
     */
    public int minDeep(Node root){
        if(root == null){
            return 0;
        }
        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);

        return leftDeep > rightDeep ? rightDeep+1:leftDeep+1;
    }

    /**
     * 获取所有叶子节点的总和
     * @param root
     * @return
     */
    public void sumLeaf(Node root){
        if(root == null){
            return;
        }
        sumLeaf(root.left);
        sumLeaf(root.right);
        // 左右节点都为空，说明是叶子节点
        if(root.left == null && root.right ==null){
            leafSum = root.getData() + leafSum;
        }
    }

    /**
     * 获取所有叶子节点的总和
     * @param root
     * @return
     */
    public int sumLeafMethodII(Node root){
        if(root == null){
            return 0;
        }
        // 左右节点都为空，说明是叶子节点
        if(root.left == null && root.right ==null){
            return root.getData();
        }
        int sumLeft = sumLeafMethodII(root.left);
        int sumRight = sumLeafMethodII(root.right);
        return sumLeft+sumRight;
    }

    /**
     * 获取指定层数节点数据之和
     *
     * 获取所有路径
     */
    public void getAllRoad(Node root,String prefix){
        if(root == null){
            return;
        }
        if(StringUtils.isBlank(prefix)){
            prefix = String.valueOf(root.getData());
        }else{
            prefix = prefix + "==>" + root.getData();
        }
        // 最终状态
        if(root.left == null && root.right == null){
            roadList.add(prefix);
        }
        getAllRoad(root.left,prefix);
        getAllRoad(root.right,prefix);
    }


    /**
     * 获取指定层数节点数据之和
     *
     * @param root
     * @param level
     * @param depth
     * @return
     */
    public void getLevelSum(Node root,Integer level,Integer depth){
        if(root == null){
            return;
        }

        if(depth < level){
            getLevelSum(root.left,level,depth+1);
            getLevelSum(root.right,level,depth+1);
        }

        if(depth.equals(level)){
            levelSum += root.getData();
        }
    }

    /**
     * 获取tree 宽度
     * @param root
     */
    public void getTreeWidth(Node root,Integer depth,Integer level){
        if (root == null) {
            return;
        }
        if(depth < level){
            getTreeWidth(root.left,depth+1,level);
            getTreeWidth(root.right,depth+1,level);
        }

        if(depth.equals(level)){
            treeWidth += 1;
        }
    }
}

