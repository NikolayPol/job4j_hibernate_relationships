package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс HistoryOwner
 *
 * @author Nikolay Polegaev
 * @version 1.0 10.11.2021
 */
@Entity
@Table(name = "history_owner", schema = "cars", catalog = "hbr_cars")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String history;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HistoryOwner that = (HistoryOwner) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HistoryOwner{"
                + "id=" + id
                + ", history='" + history + '\''
                + ", driverId=" + driver
                + '}';
    }
}
