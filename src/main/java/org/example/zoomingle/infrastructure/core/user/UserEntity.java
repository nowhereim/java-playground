package org.example.zoomingle.infrastructure.core.user;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.zoomingle.infrastructure.core.base.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String profile;

    private String description;


}
