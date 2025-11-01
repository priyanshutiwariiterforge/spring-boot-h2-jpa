package com.example.usingh2.entity;

import jakarta.persistence.*;
import lombok.*;   // ✅ Lombok annotations

// ✅ This class represents a database table named "user"
@Entity
@Table(name = "users")
@Data                     // Auto-generates Getters, Setters, toString, equals, hashCode
@NoArgsConstructor         // Creates an empty (no-args) constructor
@AllArgsConstructor         // Creates a constructor with all fields
public class User {

    @Id   // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String name;
    private String email;
}
