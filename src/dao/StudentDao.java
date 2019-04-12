package dao;

import entity.HibernateUtil;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.util.List;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class StudentDao {

    private SessionFactory sessionFactory = null;
    private Session session = null;


    private void dobefore() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }


    private void doafter() {
        session.getTransaction().commit();
        session.close();

    }

    public List<Student>  queryAll(int index, int pageCount){
        dobefore();
        String hql ="from Student ";
        Query<Student> query = session.createQuery(hql, Student.class);
        int start=(index-1)*pageCount;
        int end=pageCount;
        query.setFirstResult(start);
        query.setMaxResults(end);
        List<Student> list = query.list();
        doafter();
        return list;
    }


    public Student queryOne(int id) {
        dobefore();
        String hql = "from Student where id = :sid ";
        Query<Student> query = session.createQuery(hql, Student.class);
        query.setParameter("sid", id);
        Student student = query.list().get(0);
        doafter();
        return  student;


    }

    public int queryPage() {
        dobefore();
        String hql ="select count(*) from Student  ";
        Query<Object> query = session.createQuery(hql, Object.class);
        Object object = query.uniqueResult();
        Number number = (Number)object;
        int i = number.intValue();
        doafter();
        return i;
    }


    public void add(Student student) {
        dobefore();
        session.save(student);
        doafter();
    }


    public void update(Student student) {
        dobefore();
        session.update(student);
        doafter();
    }


    public void delete(Student student) {
        dobefore();
        session.delete(student);
        doafter();
    }
}


