package tdtu.edu.vn.Lab10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.Lab10.models.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
