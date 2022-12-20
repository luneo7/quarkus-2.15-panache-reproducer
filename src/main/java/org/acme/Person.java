package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person extends PanacheEntityBase {
    @Id
    @Column
    public Integer id;

    @Column
    public String name;
}
