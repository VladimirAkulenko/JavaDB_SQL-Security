package ru.netology.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persons")
@IdClass(PersonId.class)
public class Person {
    @Id
    @Column(nullable = false, length = 30)
    private String name;

    @Id
    @Column(nullable = false, length = 30)
    private String surname;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false, length = 150)
    private String cityOfLiving;
}
