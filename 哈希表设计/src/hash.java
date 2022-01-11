public class hash {//哈希表
    public String key;//名字的拼音
    public int m;//拼音所对应的ASCII总和，即关键字
    public int si;//查找长度

    hash(){
        this.key = key;
        this.m=m;
    }
    public hash(String key,int m,int si){
        this.key=key;
        this.m=m;
        this.si=si;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setSi(int si) {
        this.si = si;
    }

    public String getKey() {
        return key;
    }

    public int getM() {
        return m;
    }

    public int getSi() {
        return si;
    }
}
