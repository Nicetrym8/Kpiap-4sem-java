package com.labs.javalabs.models.cylinder;

import com.labs.javalabs.endpoints.cylinder.data.Cylinder;
import com.labs.javalabs.endpoints.cylinder.data.CylinderRequestParams;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CylinderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private double volume;
    private double height;
    private double radius;

    protected CylinderEntity() {
    }

    public CylinderEntity(CylinderRequestParams e) {
        this.volume = new Cylinder(e).volume();
        this.height = e.height();
        this.radius = e.radius();
    }

    public boolean equals(CylinderEntity a, CylinderEntity b) {

        return (a.volume == b.volume) && (a.radius == a.radius) && (a.height == a.height);
    }

    public double volume() {
        return this.volume;
    }

    public double radius() {
        return this.radius;
    }

    public double height() {
        return this.height;
    }

}
