package lk.ijse.gdse;

import lk.ijse.gdse.config.FactoryConfiguration;
import lk.ijse.gdse.entity.Laptop;
import lk.ijse.gdse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop1 = new Laptop();
        laptop1.setLid(1);
        laptop1.setName("Dell");

        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setName("Lenovo");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        Student student = new Student();
        student.setId(1);
        student.setName("Ann");
        student.setAddress("Colombo");
        student.setLaptops(laptops);

        laptop1.setStudent(student);
        laptop2.setStudent(student);
        session.persist(laptop1);
        session.persist(laptop2);
        session.persist(student);

        transaction.commit();
        session.close();
    }
}