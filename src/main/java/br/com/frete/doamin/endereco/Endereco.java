package br.com.frete.doamin.endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private double lat;
    @NonNull
    private double longe;

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLonge() {
        return longe;
    }

    public void setLonge(double longe) {
        this.longe = longe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;

        if (Double.compare(endereco.getLat(), getLat()) != 0) return false;
        if (Double.compare(endereco.getLonge(), getLonge()) != 0) return false;
        return getId() != null ? getId().equals(endereco.getId()) : endereco.getId() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        temp = Double.doubleToLongBits(getLat());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLonge());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
