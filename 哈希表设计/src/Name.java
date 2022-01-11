public class Name {//姓名表

    private String  key;//名字的拼音
    private   int m;//拼音所对应的ASCII总和，即关键字

    public Name(String key,int m){
        this.key=key;this.m=m;
    }

        Name(){
            this.key = key;
            this.m=m;
        }
    public void key(String key) {
        this.key = key;
    }

    public void setM(int m) {
        this.m = m;
    }

    public String getKey() {
        return key;
    }

    public int getM() {
        return m;
    }
}
