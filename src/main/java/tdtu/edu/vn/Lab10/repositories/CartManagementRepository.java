package tdtu.edu.vn.Lab10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.Lab10.models.Account;
import tdtu.edu.vn.Lab10.models.CartManagement;

import java.util.List;
import java.util.Optional;
@Repository
public interface CartManagementRepository extends JpaRepository<CartManagement,Long> {

    List<CartManagement> findByUserAccount(Optional <Account> account);

    CartManagement findBySanPhamIdAndUserAccount(Long sanPhamId, Account username);


}
