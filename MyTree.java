package com.example.sortpractice;

public class MyTree<E> {
    private Node<E>root;
    private int size;

    private static class Node<E>{
        private E element;
        private Node<E> left;
        private Node<E> right;
        Node(E element){
            this.element=element;
            left=right=null;
        }
    }
    public MyTree(){
        root=null;
        size=0;
    }
    public void dispPreOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node<E> node){
        if(node==null){
            return;
        }
        System.out.print(node.element+"");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void dispInOrder(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node<E> node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.element+"");
        inOrder(node.right);
    }

    public void dispPostOrder(){
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node<E> node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.element+"");
    }

    public void disp(int level){
        int i=0,k,n,count,margin,padding=0;
        if(level<0||level>4) {
            level = 4;
        }
        n=1;
        for(int j=0;j<=level;j++){
            n*=3;
        }
        n--;
        Node<E>[] nodes=(Node<E>[])new Node[n+1];
        for(int j=i;j<=n;j++){
            nodes[j]=new Node<E>(null);
        }
        dispsub(root,n,i,nodes);

        k=i=1;
        margin=0;
        while(margin<=n){
            margin*=2;
        }
        while (i<=n){
            if(i==k){
                count=margin;
                padding=margin*2-2;
                k*=2;
                margin/=2;
                System.out.println();
            }else {
                count=padding>=0?padding:0;
            }
            while (count-->0){
                System.out.print("");
            }
            if(nodes[i].element!=null){
                System.out.print(nodes[i].element);
            }else{
                System.out.print("--");
            }
            i++;
        }
        System.out.println();
    }

    private int dispsub(Node<E>p,int n,int number,Node<E>[] nodes){
        if(p==null){
            return  number;
        }
        if(number>n){
            return number;
        }
        nodes[number].element=p.element;
        number*=2;
        number=dispsub(p.left,n,number,nodes);
        number++;
        number=dispsub(p.right,n,number,nodes);
        number/=2;
        return  number;
    }

    public static void main(String[] argv){
        final int N=15;
        int c_l,c_r;
        int[] exist ={ 0,1,
                    1,          1,
                 1,     1,   1,     0,
                1,0,   0,0, 0,1,   0,0
        };

        MyTree<Integer>tree=new MyTree<Integer>();
        Node<Integer>[] pos=(Node<Integer>[])new Node[N+1];
        tree.root=pos[1]=new Node<Integer>(1);
        for(int i=1;i<=N/2;i++){
            c_l=i*2;
            c_r=c_l+1;
            if(exist[c_l]==1){
                pos[c_l]=pos[i].left=new Node<Integer>(c_l);
            }else{
                pos[c_l]=null;
            }
            if(c_r>N){
                break;
            }
            if(exist[c_r]==1){
                pos[c_r]=pos[i].right=new Node<Integer>(c_r);
            }else {
                pos[c_r]=null;
            }
            tree.disp(3);
            System.out.print("先行順:");
            tree.dispPreOrder();
            System.out.print("中間順:");
            tree.dispInOrder();
            System.out.print("後行順");
            tree.dispPostOrder();
            System.out.println();

        }
    }
}
