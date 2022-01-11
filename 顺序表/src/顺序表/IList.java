package 顺序表;

public interface IList {
     void insert(int index, Object data) throws Exception;		//在指定位置插入元素
     void clear();						//清空线性表
    void remove(int index);							//删除指定位置元素
     boolean isEmpty();										//判断线性表是否为空
     Object get(int index);						//获取指定位置元素
     int length();									//获取线性表长度
     int indexOf(Object data);				//获取指定元素的角标
     void display();				//输出线性表中所有元素
}
