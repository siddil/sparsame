package it.siddi.reallife.controlling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity (name="MovementKeyWords")
@Table (name="MovementKeyWords")
@SequenceGenerator(name="pks",  allocationSize=5)
public class MovementKeyWords {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "pks")
    @JsonIgnore
    private Long id;

    @JsonProperty(required = true)
    private String keyWord;

    @Enumerated
    @Column(columnDefinition = "smallint",name="fk_mov_type")
    @JsonProperty(required = true)
    private MovementType type;

    public MovementKeyWord() {
    }

    public MovementKeyWord(String keyWord, MovementType type) {
        this.keyWord= keyWord;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public MovementKeyWord setId(Long id) {
        this.id = id;
        return this;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }
}
