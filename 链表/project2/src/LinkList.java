import java.util.Scanner;

public class LinkList implements IList{
    public Node head;	//单链表头指针
    public LinkList() {
        head = new Node();
    }
    public LinkList(int n,boolean order) {
        this();
        if(order)
            creat1(n);
        else
            creat2(n);
    }
    //头插法——读入的数据顺序与结点顺序相反
    public void creat1(int n) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++) {
            try {
                insert(0, sc.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //尾插法——读入的数据顺序与结点顺序相同
    public void creat2(int n) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++) {
            try {
                insert(length(), sc.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //向单链表插入数据
    public void insert(int index, Object data) throws Exception {
        Node preNode = head;
        int preIndex;
        for(preIndex=-1;preIndex<index-1&&preNode!=null;preIndex++) {		//查找所插入位置的前驱结点
            preNode = preNode.next;
        }
        if(preIndex>index-1||preNode==null)		//操作不合法则抛出异常
            throw new Exception("非法操作！");
        Node newNode = new Node(data);		//创建新插入的结点对象
        newNode.next = preNode.next;		//更新指针域指向
        preNode.next = newNode;
    }
    //清空单链表
    public void clear() {
        head.data = null;
        head.next = null;
    }
    //删除节点
    public void remove(int index) throws IndexOutOfBoundsException{
        Node preNode = head;
        int preIndex;
        for(preIndex=-1;preIndex<index-1&&preNode!=null;preIndex++) {		//查找待删除元素的前驱结点
            preNode = preNode.next;
        }
        if(preIndex>index-1||preNode==null)		//操作不合法则抛出异常
            throw new IndexOutOfBoundsException("角标越界了！");
        preNode.next = preNode.next.next;

    }
    //判断单链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }
    //获取位置index处的数据
    public Object get(int index) throws IndexOutOfBoundsException {
        Node nextNode = head.next;
        int j;
        for(j=0;j<index&&nextNode!=null;j++)		//从首结点开始查找，直到index处或nextNode为null，即查找结束
            nextNode = nextNode.next;
        if(j>index||nextNode==null)		//操作不合法则抛出异常
            throw new IndexOutOfBoundsException("元素不存在！");

        return nextNode.data;
    }
    //获取单链表长度
    public int length() {
        Node nextNode = head.next;
        int length = 0;
        while(nextNode!=null) {
            nextNode = nextNode.next;
            length++;
        }
        return length;
    }
    //按值查找对应的角标
    public int indexOf(Object data) {
        Node nextNode = head.next;
        int index;
        for(index=0;nextNode!=null;index++) {
            if(nextNode.data.equals(data))
                return index;
        }
        return -1;
    }
    @Override
    public void display() {
        Node root;

        head.data="    ";
        root=new Node("通讯录",head);// 设置节点关系// 设置节点关系
        // 第二步：根据节点关系取出所有数据
        Node currentNode = root;                  // 当前从根节点开始读取
        while (currentNode != null) {                        // 当前节点存在数据
            System.out.println(currentNode.data);
            currentNode = currentNode.next;            // 将下一个节点设置为当前节点


    }}

}
