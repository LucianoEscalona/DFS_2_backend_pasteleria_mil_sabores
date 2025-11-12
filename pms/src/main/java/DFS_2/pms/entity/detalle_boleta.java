package DFS_2.pms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="DETALLE_BOLETA")
public class detalle_boleta {
    
    @Id
    @GeneratedValue
    private int bd_id;
    
    @Column(name="bd_id_boleta")
    private int bd_id_boleta;

}
