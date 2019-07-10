import java.util.Arrays;

public class MakeTree {
        public static BinaryTreeNode buildBST(int[] keys){
            Arrays.sort(keys);                 //Takes nlogn =O(nlogn).
            int medium = keys.length / 2;
            return new BinaryTreeNode(tree(keys, 0, medium - 1), keys[medium], tree(keys, medium + 1, keys.length - 1));
            //2T(n/2)   (From helper)

            //Therefore it's run time is 2*logn + nlogn = O(nlogn)
        }
        public static BinaryTreeNode tree(int[] keys, int low, int high) {
            if(low==high){
                return new BinaryTreeNode(keys[(low+high)/2]);
            }
            else{
                int mid=(low+high)/2;
                if(mid-1<low){
                    return new BinaryTreeNode(null,keys[mid],tree(keys,mid+1,high));
                }
                if(mid+1>high){
                    return new BinaryTreeNode(tree(keys,low,mid-1),keys[mid],null);
                }

                return new BinaryTreeNode(tree(keys,low,mid-1),keys[mid],tree(keys,mid+1,high));
            }
        }
}