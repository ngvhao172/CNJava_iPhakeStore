package tdtu.edu.vn.Lab10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.Lab10.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

}
