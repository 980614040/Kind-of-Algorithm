public class Node {
    public Object data;		//数据域
    public Node next;		//指针域

    public Node(){
        this(null,null);
    }

    public Node(Object data){
        this(data,null);
    }
    public Node(Object data,Node next){
        this.data = data;
        this.next = next;
    }
}
