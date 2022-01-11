package 顺序表;

public class SqList implements IList {
    private Object[] listItem;		//顺序表的存储空间大小；
    private int curLen;				//顺序表的当前长度
    private int maxSize;			//顺序表的最大尺寸

    //构造最大尺寸为maxSize的顺序表
    //设置顺序表的长度
    public void setListItem(int maxSize,int curLen)
    {
        this.maxSize=maxSize;
        this.curLen = curLen;
        this.listItem = new Object[maxSize];
    }
    //在第index的位置插入数据data
    public void insert(int index, Object data) throws Exception{
        if(curLen == maxSize)					//判断存储空间是否已满
            throw new Exception("数组已满，无法插入！");
        if(index<0||index>curLen)				//判断插入位置是否合法
            throw new IndexOutOfBoundsException("所插入的位置不在索引范围！");
        for(int i=curLen;i>index;i--) {			//将插入位置后面的所有元素后移一位
            listItem[i]=listItem[i-1];
        }
        listItem[index] = data;					//插入数据
        curLen++;								//表长+1
    }
    //清空顺序表
    public void clear() {
        curLen = 0;
    }
    //删除顺序表中指定位置index处的数据
    public void remove(int index) throws IndexOutOfBoundsException{
        if(index<0||index>curLen)				//判断位置是否合法
            throw new IndexOutOfBoundsException("当前索引不存在！");
        for(int i=index;i<curLen;i++) {			//将指定位置之后的元素均前移一位
            listItem[i] = listItem[i+1];
        }
        curLen--;								//表长-1
    }
    //判断顺序表是否为空
    public boolean isEmpty() {
        return curLen == 0;
    }
    //获取交表为index处的数据
    public Object get(int index) throws IndexOutOfBoundsException{
        if(index<0||index>curLen)
            throw new IndexOutOfBoundsException("当前索引不存在！");
        return listItem[index];
    }
    //返回顺序表长度
    public int length() {
        return curLen;
    }
    //获取元素在顺序表中的位置
    public int indexOf(Object data) {
        for(int i=0;i<curLen;i++) {
            if(listItem[i] == data)
                return i;
        }
        return -1;
    }
    //显示顺序表中的元素
    public void display() {
        for(int i=0;i<curLen;i++)
            System.out.print(listItem[i]);
    }



}

