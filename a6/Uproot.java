import java.util.*;


public class Uproot {
    static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        doMapping(mapping, T, null);
        return mapping;
    }
    static void doMapping(Map<Integer, Integer> map, BinaryTreeNode node, Integer parent){

        if (node != null) {
            if (parent == null) {
                doMapping(map, node.left, node.key);
                doMapping(map, node.right, node.key);
            }
            else{
                map.put(node.key, parent);
                doMapping(map, node.left, node.key);
                doMapping(map, node.right, node.key);
            }
        }
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        int root=map.keySet().iterator().next();
        while(map.containsKey(root)){
            root=map.get(root);
        }
        BinaryTreeNode btn=new BinaryTreeNode(root);
        for(int k:map.keySet()){
            List<Integer> val=new ArrayList<>();
            if(m.containsKey(map.get(k))){
                m.get(map.get(k)).add(k);
            }
            else{
                val.add(k);
                m.put(map.get(k),val);
            }
        }

        return TreeMp(m,null,root);
    }
    public static BinaryTreeNode TreeMp(Map<Integer, List<Integer>> map,BinaryTreeNode btn, int key){
        List<Integer> list= map.get(key);
        if(map.get(key)==null){
            return btn;
        }
        if (map.get(key).size() == 2) {
            int left = map.get(key).get(0);
            int right = map.get(key).get(1);
            btn.left = new BinaryTreeNode(left);
            btn.right = new BinaryTreeNode(right);
            TreeMp(map, btn.left,left);
            TreeMp(map, btn.right,right);
        }
        else if(list.size()==1){
            int left = map.get(key).get(0);
            btn.left = new BinaryTreeNode(map.get(key).get(0));
            TreeMp(map,  btn.left,left);
        }
        return btn;
    }
}
