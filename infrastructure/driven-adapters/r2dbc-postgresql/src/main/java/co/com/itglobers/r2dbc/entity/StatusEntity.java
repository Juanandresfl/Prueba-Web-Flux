package co.com.itglobers.r2dbc.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "status", schema = "public")
public class StatusEntity {
    @Id
    @Column("status_id")
    private Integer id;

    @Column("name")
    private String name;
}
