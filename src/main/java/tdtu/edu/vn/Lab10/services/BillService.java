package tdtu.edu.vn.Lab10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.Lab10.models.Account;
import tdtu.edu.vn.Lab10.models.Bill;
import tdtu.edu.vn.Lab10.repositories.BillRepository;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public Bill save(Bill billDetail){
        return billRepository.save(billDetail);
    }

    public List<Bill> getAllBillByUserAcccount(Account useraccount){
        return billRepository.getAllByUserAccount(useraccount);
    }
}
