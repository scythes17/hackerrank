// Also known as level order traversal for a BST
import java.util.*;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

class BST{
    static void levelOrder(Node root){
      //Write your code here
        Queue<Node> q = new LinkedList<>();
        if(root != null){
            q.add(root);
        }
        while(!q.isEmpty()){
            Node ele = q.remove();
            System.out.print(ele.data+" ");
            if(ele.left != null)
                q.add(ele.left);
            if(ele.right != null)
                q.add(ele.right);
        }
    }

    static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static int getHeight(Node root){
        //Write your code here
        if(root == null)
            return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(); // number of nodes
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        System.out.println("level Order traversal or BFS: ");
        levelOrder(root);
        System.out.println();
        System.out.println("In Order traversal: ");
        inOrder(root);
        System.out.println();
        System.out.println("Post Order traversal: ");
        postOrder(root);
        System.out.println();
        System.out.println("Pre Order traversal: ");
        preOrder(root);
        System.out.println();
        int height=getHeight(root);
        System.out.println("height: "+height);
        sc.close();
    }	
}