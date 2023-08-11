package global.goit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "planet_id")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Planet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}