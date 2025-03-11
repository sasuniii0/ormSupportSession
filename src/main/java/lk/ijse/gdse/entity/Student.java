package lk.ijse.gdse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String address;

    @OneToMany (mappedBy = "student")
    private List<Laptop> laptops; // One student has many laptops>
}
