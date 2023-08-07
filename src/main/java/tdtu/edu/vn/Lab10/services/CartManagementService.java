package tdtu.edu.vn.Lab10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.Lab10.models.Account;
import tdtu.edu.vn.Lab10.models.CartManagement;
import tdtu.edu.vn.Lab10.repositories.AccountRepository;
import tdtu.edu.vn.Lab10.repositories.CartManagementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartManagementService {
    @Autowired
    CartManagementRepository cartManagementRepository;
    @Autowired
    AccountRepository accountRepository;
    public CartManagement save(CartManagement cartManagement){
        return cartManagementRepository.save(cartManagement);
    }
    public List<CartManagement> getAllCartManagementByUserAccount(String username){
        Optional<Account> account = accountRepository.findById(username);

        return cartManagementRepository.findByUserAccount(account);
    }
    public CartManagement findBySanPhamIdAndUserAccount(Long sanPhamId, Account username){
        return cartManagementRepository.findBySanPhamIdAndUserAccount(sanPhamId,username);
    }

    public void deleteCartManagement(CartManagement cartManagement){
        cartManagementRepository.delete(cartManagement);
    }
}
