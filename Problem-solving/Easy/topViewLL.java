import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
/*class Node2{
    int position;
    Node node;

    Node2(Node node, int position){
        this.position = position;
        this.node = node;
    }
}*/
class topViewLL {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
    */
    
    // Based on Vertical Order Traversal.
	public static void topView(Node root) {
        class Node2{
            int position;
            Node node;

            Node2(Node node, int position){
                this.position = position;
                this.node = node;
            }
        }
        if(root == null)
            return;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node2> q = new LinkedList<>();
        q.add(new Node2(root, 0));
        while(!q.isEmpty()) { // checks each level then goes to the next Level Order Traversal
            Node2 qEle = q.poll();
            if(!map.containsKey(qEle.position)) // if the position is unoccupied add node
                map.put(qEle.position, qEle.node);
            if(qEle.node.left != null) // check left
                q.add(new Node2(qEle.node.left, qEle.position-1));
            if(qEle.node.right != null) // check right
                q.add(new Node2(qEle.node.right, qEle.position+1));
        }
        TreeMap<Integer, Node> tree = new TreeMap<>();
        tree.putAll(map);
        for(Map.Entry<Integer, Node> treeEle: tree.entrySet()){
            System.out.print(treeEle.getValue().data+" ");
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}