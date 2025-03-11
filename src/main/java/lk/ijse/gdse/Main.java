package lk.ijse.gdse;

import lk.ijse.gdse.config.FactoryConfiguration;
import lk.ijse.gdse.entity.Laptop;
import lk.ijse.gdse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setName("Dell");

        Student student = new Student();
        student.setId(1);
        student.setName("Joe");
        student.setAddress("Kandy");

        session.persist(laptop);
        session.persist(student);

        transaction.commit();
        session.close();
    }
}