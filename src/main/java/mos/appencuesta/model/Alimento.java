package mos.appencuesta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alimento")
public class Alimento {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nameFood")
        private String nameFood;
        @Column(name = "nameDrink")
        private String nameDrink;
        @Column(name = "nameDessert")
        private String nameDessert;

        private Integer VisualId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getNameDessert() {
        return nameDessert;
    }

    public void setNameDessert(String nameDessert) {
        this.nameDessert = nameDessert;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public Integer getVisualId() {
        return VisualId;
    }

    public void setVisualId(Integer visualId) {
        VisualId = visualId;
    }

    @Override
    public String toString() {
        return "ID Visual: " + VisualId + " | Comida: " + nameFood + ", Bebida: " + nameDrink + ", Postre: " + nameDessert;
    }


}
