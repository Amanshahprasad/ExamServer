package com.exam.ExamServer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    private Long roleId;
    private String roleName;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "roles")
    @JsonIgnore
    private List<User> users;
}
