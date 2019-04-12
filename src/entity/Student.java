package entity;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
public class Student {

    private int id;
    private String name;
    private int cid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Student() {
    }

    public Student(String name, int cid) {
        this.name = name;
        this.cid = cid;
    }

    public Student(int id, String name, int cid) {
        this.id = id;
        this.name = name;
        this.cid = cid;
    }
}
