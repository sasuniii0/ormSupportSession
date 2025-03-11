package lk.ijse.gdse;

import lk.ijse.gdse.config.FactoryConfiguration;
import lk.ijse.gdse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*
        Student student = new Student();
        student.setId(2);
        student.setName("Ann2");
        student.setAddress("Gampaha2");
        */

        //session.save(student);
        //session.update(student);
        //System.out.println(session.get(Student.class, 1));
        session.delete(session.get(Student.class, 2));

        transaction.commit();
        session.close();
    }
}