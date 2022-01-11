public class Node {
    public Object data;		//数据域
    public Node next;		//指针域
    public Object position;//位置数据

    public Node(){
        this(null,null,null);
    }

    public Node(Object data,Object position){
        this(data,position,null);
    }
    public Node(Object data,Object position,Node next){
        this.data = data;
        this.next = next;
        this.position=position;
    }
}
