package ua.com.agileboard.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "columns", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "columns_unique_name_idx")})
public class BoardColumn extends AbstractNamedEntity {

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    @Size(max = 255)
    private String name;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boardColumn", cascade = CascadeType.REMOVE)
    @OrderBy("name DESC")
    protected Set<Card> cards;

    public BoardColumn() {
    }

    public BoardColumn(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public BoardColumn(Integer id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "BoardColumn{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
