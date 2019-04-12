package servlet;

import dao.StudentDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
@javax.servlet.annotation.WebServlet(name = "StudentsServlet",urlPatterns = "/StudentsServlet")
public class StudentsServlet extends javax.servlet.http.HttpServlet {
    private StudentDao dao=new StudentDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String method=req.getParameter("method");
        if("add".equals(method)){
            add(req,resp );

        }else if("delete".equals(method)){
            delete(req,resp );

        }else if("query".equals(method)){
            query(req,resp );

        }else if("update".equals(method)){
            update(req,resp );

        }else if("queryOne".equals(method)){
            queryOne(req,resp );}


    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sName =req.getParameter("sName");
        String CId = req.getParameter("CId");
        Student student=new Student(sName,Integer.parseInt(CId));
        dao.add(student);
        resp.sendRedirect(req.getContextPath()+"/StudentsServlet?method=query");

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = dao.queryOne(Integer.parseInt(id));
        dao.delete(student);
        resp.sendRedirect(req.getContextPath()+"/StudentsServlet?method=query");
    }
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = req.getParameter("index");
        if(index==null){
            index="1";
        }
        int pageCount=3;

        List<Student> all = dao.queryAll(Integer.parseInt(index),pageCount);

        int count = dao.queryPage();
        int pages=(count+pageCount-1)/pageCount;
        req.setAttribute("end",pages);
        req.setAttribute("all",all);
        req.getRequestDispatcher("/query.jsp").forward(req,resp);
    }
    protected void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = dao.queryOne(Integer.parseInt(id));

        req.setAttribute("student",student);
        req.getRequestDispatcher("queryOne.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sId = req.getParameter("sId");
        String sName =req.getParameter("sName") ;
        String CId = req.getParameter("CId");
        Student student=new Student();
        student.setId(Integer.parseInt(sId));
        student.setName(sName);
        student.setCid(Integer.parseInt(CId));
        dao.update(student);
        resp.sendRedirect(req.getContextPath()+"/StudentsServlet?method=query");
    }
}
