import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    #include<stdio.h>
//#include<time.h>//time用到的头文件
//#include<stdlib.h>//随机数srand用到的头文件
//#include<ctype.h>//toascii()用到的头文件
//#include<string.h>//查找姓名时比较字符串用的头文件
     int hash_LEN =50;//哈希表的长度
     int P= 47;//小于哈希表长度的P
     int NAME_LEN=30;//姓名表的长度
    public char key;//名字的拼音
    public int m;//拼音所对应的ASCII总和，即关键字
    public int si;//查找长度
    hash [] hash=new hash[hash_LEN];
    Name [] name=new Name[NAME_LEN];
    Name name1=new Name();
//
//    List<hash>[] hashes= (List<hash>[]) new List[hash_LEN];
//
//
//
//        //全局定义姓名表,最大长度为50
//    List<Name>[] names= (List<Name>[]) new List[NAME_LEN];//全局定义哈希表，最大长度为50
    int d[]=new int[30];    //全局定义随机数,循环用的i、j

    public void InitName()
    {//姓名表的初始化
        for (int i = 0; i <NAME_LEN ; i++) {
            name[i]=new Name();
        }

        name[0].key("lvsongxian");
        name[1].key("yuanlei");
        name[2].key("daiziwen");
        name[3].key("chenyonghui");
        name[4].key("zhangliang");
        name[5].key("liubei");
        name[6].key("sunshangxiang");
        name[7].key("liyuanfang");
        name[8].key("huge");
        name[9].key("liuyifei");
        name[10].key("anyixuan");
        name[11].key("wangbaoqiang");
        name[12].key("yangyiming");
        name[13].key("hujing");
        name[14].key("guowen");
        name[15].key("xuyang");
        name[16].key("lilu");
        name[17].key("shenjinfeng");
        name[18].key("xuhui");
        name[19].key("huangjing");
        name[20].key("guanyu");
        name[21].key("chenlong");
        name[22].key("huangliang");
        name[23].key("liyan");
        name[24].key("haojian");
        name[25].key("zhangfei");
        name[26].key("shuxiang");
        name[27].key("sunyingjie");
        name[28].key("wangbo");
        name[29].key("zhaoqing");
        for (int i=0;i<NAME_LEN;i++)    //将字符串的各个字符所对应的ASCII码相加，所得的整数做为哈希表的关键字
        {
            int s=0;
            String  p=name[i].getKey();
            for (int j=0;j<p.length();j++)
            {
                System.out.println(Integer.parseInt(stringToAscii(p)[j]));
                s+=Integer.parseInt(stringToAscii(p)[j]);
                name[i].setM(s);
            }
        }
    }

    public static String[] stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        String finallsbu[] = new String[0];
        String[] leftArr2 = sbu.toString().split("\\,");
        return leftArr2;
    }

    public void Createhash()
    {//建立哈希表
        for(int i=0;i<hash_LEN;i++) //清空哈希表，未经此操作将储存空数据
        {
            hash[i]=new hash();
            hash[i].setKey("1");
            hash[i].setM(0);
            hash[i].setSi(0);
        }
        for(int i=0;i<NAME_LEN;i++)
        {
            int sum=1,j=0,t;
            int adr=(name[i].getM())%P;  //除留余数法H(key)=key%P，除数为P=47
            if(hash[adr].getSi()==0)     //如果不冲突，将姓名表赋值给哈希表
            {
                hash[adr].setM(name[i].getM());
                hash[adr].setKey(name[i].getKey());
                hash[adr].setSi(1);
            }
            else                         //如果冲突
            {
                t=adr;        //线性探测法处理冲突
                for(;hash[adr].getSi()!=0&&adr<hash_LEN;adr++)//从冲突下一个位置开始探测
                {
                    sum=sum+1;//每次查找，查找次数+1
                    if(adr==hash_LEN-1)//如果找到最后一个仍然没有位置
                    {
                        for(;hash[adr].getSi()!=0&&adr<t;adr++)//从第一个开始探测
                            sum=sum+1;//每次查找，查找次数+1
                        if(adr==t) System.out.println("哈希表已满\n");//如果找到上次的位置仍然没有，则输出哈希表已满
                    }
                }
                hash[adr].setM(name[i].getM());   //将姓名表复制给哈希表对应的位置上
                hash[adr].setKey(name[i].getKey());
                hash[adr].setSi(sum);
            }
        }
    }

    public void DisplayName()//显示姓名表
    {
        System.out.println("\n地址 \t\t 姓名 \t\t 关键字\n");
        for (int i=0;i<NAME_LEN;i++)
            System.out.println("\n"+i+"\t\t\t"+name[i].getKey()+" \t\t\t"+name[i].getM());
    }

    public void Displayhash()// 显示哈希表
    {
        double asl=0.0;
        System.out.println("\n\n 地址 \t\t 姓名 \t\t 关键字 \t 搜索长度\n"); //显示的格式
        for (int i=0;i<hash_LEN;i++)
        {

            System.out.println("\n"+i+"\t\t\t"+hash[i].getKey()+" \t\t\t"+hash[i].getM()+"\t\t"+hash[i].getSi());
            asl+=hash[i].getSi();

        }
        System.out.println();
        asl=NAME_LEN;//求得ASL
        System.out.print("NAME_LEN:"+NAME_LEN+":");
        System.out.print(asl);
        
    }

   public void FindName()//查找
    {
//        String name[20]={0};
        String name;
        int s=0,sum=1,adr;
        System.out.println("\n请输入想要查找的姓名的拼音:");
        Scanner scanf=new Scanner(System.in);
         name=scanf.next();
//        scanf("%s",name);
//        getchar();
        for (int j=0;j<name.length();j++)//求出姓名的拼音所对应的ASCII作为关键字
        {System.out.println("name[j]:"+stringToAscii(name)[j]);
            System.out.println(s);
        s+=Integer.parseInt(stringToAscii(name)[j]);
            }

        adr=s%P;           //除留余数法
        int j=0;
        if(hash[adr].getM()==s&&hash[adr].getKey().equals(name)) //分3种情况进行判断，并输出查找结果
            System.out.println("\n姓名:"+hash[adr].getKey()+"   关键字:"+s+"   地址:"+adr+"   查找长度为: 1\n");
        else if (hash[adr].getM()==0)
            System.out.println("\n没有想要查找的人!\n");
        else
        {
            while(true)
            {
                System.out.println(j);
                System.out.println("d[j]:"+d[j]);
                adr=(adr+d[j++])%hash_LEN;//伪随机探测再散列法处理冲突
                sum=sum+1;                //查找次数加1
                if(hash[adr].getM()==0)
                {
                    System.out.println("\n没有想要查找的人!\n");
                    break;
                }
                if(hash[adr].getM()==s&&!hash[adr].getKey().equals(name))
                {
                    System.out.println("\n姓名:"+hash[adr].getKey()+"   关键字:"+adr+"   地址:"+s+"   查找长度为: "+sum+"\n");

                    break;
                }
            }
        }
    }


    public void view()//交互界面
    {
        System.out.println("=======================================================\n");
        System.out.println("=                                                     =\n");
        System.out.println("=                   人名哈希表                        =\n");
        System.out.println("=                                                     =\n");
        System.out.println("=  A: 打印姓名表                 B: 打印哈希表        =\n");
        System.out.println("=                                                     =\n");
        System.out.println("=  C: 查找                       D: 退出程序          =\n");
        System.out.println("=                                                     =\n");
        System.out.println("=======================================================\n");
    }

    public static void main(String[] args) {

        Main main=new Main();
        int hash_LEN =50;//哈希表的长度
        int P= 47;//小于哈希表长度的P
        int NAME_LEN=30;//姓名表的长度
        String c;
       boolean a=true;
//        srand((int)time(0));//以当前时间对应的int值为随机序列起点，每次运行程序由于起点不同可以得到不同的随机数序列
//        for(i=0;i<30;i++)//用随机函数求得伪随机数列d[i]（在1到50之间）
//            d[i]=1+(int)(hash_LEN*rand()/(RAND_MAX+1.0));
        main.InitName();//调用初始化姓名表函数
        main.Createhash();//调用创建哈希表函数
        main.view();//调用交互界面函数
        while(a)
        {
            System.out.println("\n输入选项:");
            Scanner SCANF=new Scanner(System.in);
            c=SCANF.next();

            switch(c)//根据选择进行判断，直到选择退出时才可以退出
            {
                case "A":
                case "a": main.DisplayName(); break;//打印姓名表
                case "B":
                case "b": main.Displayhash(); break;//打印哈希表
                case "C":
                case "c": main.FindName(); break;//调用查找函数
                case "D":
                case "d": a=false; break;//退出循环，终止程序
                default: System.out.println("\n请输入正确的选择!\n"); break;
            }
        }

    }


}
