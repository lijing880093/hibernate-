package entity;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class PageBean {
    private int count;
    private int pageIndex=1;
    private int pageCount;
    public int getIndex() {

        return (pageIndex-1)*pageCount;
    }
    public int getPages() {

        return (count+pageCount-1)/pageCount;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
