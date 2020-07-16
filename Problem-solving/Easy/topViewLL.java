import java.util.*;

class Node1 {
    Node1 left;
    Node1 right;
    int data;
    
    Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
/*class Node12{
    int position;
    Node1 node1;

    Node12(Node1 node1, int position){
        this.position = position;
        this.node1 = node1;
    }
}*/
class topViewLL {

	/* 
    
    class Node1 
    	int data;
    	Node1 left;
    	Node1 right;
    */
    
    // Based on Vertical Order Traversal.
	public static void topView(Node1 root) {
        class Node12{
            int position;
            Node1 node1;

            Node12(Node1 node1, int position){
                this.position = position;
                this.node1 = node1;
            }
        }
        if(root == null)
            return;
        HashMap<Integer, Node1> map = new HashMap<>();
        Queue<Node12> q = new LinkedList<>();
        q.add(new Node12(root, 0));
        while(!q.isEmpty()) { // checks each level then goes to the next Level Order Traversal
            Node12 qEle = q.poll();
            if(!map.containsKey(qEle.position)) // if the position is unoccupied add node1
                map.put(qEle.position, qEle.node1);
            if(qEle.node1.left != null) // check left
                q.add(new Node12(qEle.node1.left, qEle.position-1));
            if(qEle.node1.right != null) // check right
                q.add(new Node12(qEle.node1.right, qEle.position+1));
        }
        TreeMap<Integer, Node1> tree = new TreeMap<>();
        tree.putAll(map);
        for(Map.Entry<Integer, Node1> treeEle: tree.entrySet()){
            System.out.print(treeEle.getValue().data+" ");
        }
    }

	public static Node1 insert(Node1 root, int data) {
        if(root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
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
        Node1 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}