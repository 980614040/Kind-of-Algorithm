


    import java.util.Scanner;

    public class main {

        public static void main(String[] args) throws Exception {
            LinkList sql=new LinkList();
            Scanner scan = new Scanner(System.in);

            while (true){
                System.out.println();
                System.out.println("1.新建通讯录");
                System.out.println("2.插入手机号");
                System.out.println("3.删除手机号");
                System.out.println("4.查询通讯录");
                System.out.println("0.退出");

                switch (scan.nextInt()){
                    case 1:{
                        System.out.println("请输入通讯录最大储存数量");
                        int maxSize=scan.nextInt();
                        sql.creat1(1);
                        break;
                    }
                    case 2:{
                        System.out.println("请输入在第几列插入手机号");
                        int index=scan.nextInt();
                        String phone=scan.next().toString();
                        sql.insert(index,phone);
                        break;
                    }
                    case 3:{
                        System.out.println("请输入在第几列删除手机号");
                        int index=scan.nextInt();
                        sql.remove(index);
                        break;
                    }
                    case 4:{
                        sql.display();
                        break;
                    }
                    case 0:{
                        break;
                    }
                }
            }


        }



    }


