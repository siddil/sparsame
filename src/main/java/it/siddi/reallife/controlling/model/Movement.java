package it.siddi.reallife.controlling.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity (name="Movement")
@Table (name="Movement")
@SequenceGenerator(name="pks",  allocationSize=5)
public class Movement {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "pks")
    @JsonIgnore
    private Long id;
    @JsonProperty(required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    @JsonProperty(required = true)
    private String reason;
    @JsonProperty(required = true)
    private Float amount;
    @Enumerated
    @Column(columnDefinition = "smallint",name="fk_mov_type")
    @JsonProperty(required = true)
    private MovementType type;

    public Movement() {
    }

    public Movement(Date name, String reason, Float amount, MovementType type) {
        this.date = name;
        this.reason = reason;
        this.amount = amount;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Movement setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Movement setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Movement setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }
}
