package tdtu.edu.vn.Lab10.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@Table(name = "tbl_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    private String username;
    private String password;
}
