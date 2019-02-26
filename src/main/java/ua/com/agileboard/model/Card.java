package ua.com.agileboard.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "cards", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "columns_unique_name_idx")})
public class Card extends AbstractNamedEntity{

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    @Size(max = 255)
    private String name;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "column_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    protected BoardColumn boardColumn;

    public Card() {
    }

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Card(Integer id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoardColumn getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(BoardColumn boardColumn) {
        this.boardColumn = boardColumn;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
