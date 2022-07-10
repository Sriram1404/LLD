package core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Player {
    Long id = System.currentTimeMillis();
    String name;
    Integer position;
    Boolean isWon;
}
