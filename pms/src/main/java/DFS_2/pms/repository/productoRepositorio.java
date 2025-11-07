package DFS_2.pms.repository;

import DFS_2.pms.entity.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepositorio extends JpaRepository<producto, Integer>{
    
    public producto findByCategoria(String categoria);
    public producto findByNombre(String nombre);
}
