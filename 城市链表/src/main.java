


    import java.util.Scanner;

    public class main {

        public static void main(String[] args) throws Exception {
            LinkList sql=new LinkList();
            Scanner scan = new Scanner(System.in);
            while (true){
                System.out.println();
                System.out.println("1.按城市名查找坐标");
                System.out.println("2.插入城市信息");
                System.out.println("3.删除城市信息");
                System.out.println("4.查询城市信息");
                System.out.println("5.位置查询");
                System.out.println("0.退出");
                switch (scan.nextInt()){
                    case 1:{
                        System.out.println("请输入城市名");
                        String city_name=scan.next();
                        int index=sql.indexOfname(city_name);
                        String city_position=sql.getposition(index).toString();
                        System.out.println(city_name+" "+city_position);
                        break;
                    }
                    case 2:{
                        System.out.println("请输入在第几列插入城市信息");
                        int index=scan.nextInt();
                        String city_name=scan.next().toString();
                        String city_position=scan.next().toString();
                        sql.insert(index,city_name,city_position);
                        break;
                    }
                    case 3:{
                        System.out.println("请输入在第几列删除城市信息");
                        int index=scan.nextInt();
                        sql.remove(index);
                        break;
                    }
                    case 4:{
                        sql.display();
                        break;
                    }
                    case 5:{
                        System.out.println("请输入位置坐标P和一个距离D");
                        int P=scan.nextInt();
                        int D=scan.nextInt();
                        int index=sql.indexOfposition(D);
                        String city_position=sql.getposition(index).toString();
                        String city_name=sql.getname(index).toString();
                        System.out.println(city_name+" "+city_position);
                    }
                    case 0:{
                        break;
                    }
                }
            }


        }



    }


