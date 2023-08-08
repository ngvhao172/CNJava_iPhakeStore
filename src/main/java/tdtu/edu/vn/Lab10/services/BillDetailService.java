package tdtu.edu.vn.Lab10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.Lab10.models.BillDetail;
import tdtu.edu.vn.Lab10.repositories.BillDetailRepository;

import java.util.List;

@Service
public class BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;

    public BillDetail save(BillDetail billDetail){
        return billDetailRepository.save(billDetail);
    }

    public List<BillDetail> getBillDetailByBillId(Long billId){
        return billDetailRepository.getBillDetailByBill_Id(billId);
    }

}
