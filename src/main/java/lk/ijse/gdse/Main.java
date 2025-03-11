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
        laptop1.setName("Lenovo");

        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setName("Dell");

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Chamath");
        student1.setAddress("Colombo");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Kasun");
        student2.setAddress("Galle");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        laptop2.setStudents(students);
        laptop1.setStudents(students);

        student1.setLaptops(laptops);
        student2.setLaptops(laptops);

        session.persist(laptop1);
        session.persist(laptop2);

        session.persist(student1);
        session.persist(student2);

        transaction.commit();
        session.close();
    }
}