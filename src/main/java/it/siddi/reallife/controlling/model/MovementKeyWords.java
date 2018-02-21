package it.siddi.reallife.controlling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity (name="Keywords")
@Table (name="Keywords")
@SequenceGenerator(name="pks",  allocationSize=5)
public class MovementKeyWords {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "pks")
    @JsonIgnore
    private Long id;

    @JsonProperty(required = true)
    private String keyword;

    @Enumerated
    @Column(columnDefinition = "smallint",name="fk_mov_type")
    @JsonProperty(required = true)
    private MovementType type;

    public MovementKeyWords() {
    }

    public MovementKeyWords(String keyWord, MovementType type) {
        this.keyword = keyWord;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public MovementKeyWords setId(Long id) {
        this.id = id;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }
}
