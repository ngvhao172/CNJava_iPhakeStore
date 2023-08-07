package tdtu.edu.vn.Lab10.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tdtu.edu.vn.Lab10.models.*;
import tdtu.edu.vn.Lab10.services.BillDetailService;
import tdtu.edu.vn.Lab10.services.BillService;
import tdtu.edu.vn.Lab10.services.CartManagementService;
import tdtu.edu.vn.Lab10.services.ProductService;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class BillController {
    @Autowired
    CartManagementService cartManagementService;
    @Autowired
    ProductService productService;
    @Autowired
    BillDetailService billDetailService;
    @Autowired
    BillService billService;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/order")
    public String getOrder(Model model){
        Account account = (Account) session.getAttribute("account");
        double total = 0;
        List<CartManagement> cartManagementList = cartManagementService.getAllCartManagementByUserAccount(account.getUsername());
        for (CartManagement cartManagement : cartManagementList) {
            Product product = productService.getProductById(cartManagement.getSanPhamId());
            total += cartManagement.getTongTien();
        }
        //tạo ra bill mới
        Bill billAddLast = billService.save(new Bill(LocalDate.now(),total, account));
        // tạo các bill detail -> add vào bill
        List<BillDetail> billDetailList = new ArrayList<>();
        for (CartManagement cartManagement : cartManagementList) {
            Product product = productService.getProductById(cartManagement.getSanPhamId());
            BillDetail billDetail = new BillDetail(product.getPrice(),cartManagement.getSoLuong(),cartManagement.getTongTien(),product, billAddLast);
            billDetailService.save(billDetail);
            billDetailList.add(billDetail);

        }
        //xóa các cartmanagement sau khi add hoàn tất
        for (CartManagement cartManagement : cartManagementList) {
            cartManagementService.deleteCartManagement(cartManagement);
        }

        model.addAttribute("billDetailList", billDetailList);
        model.addAttribute("billInfor", billAddLast);
        model.addAttribute("fullname", request.getParameter("fullname"));
        model.addAttribute("address", request.getParameter("address"));
        model.addAttribute("phonenumber", request.getParameter("phonenumber"));
        return "order";
    }
   @GetMapping("/order")
   public String getOrder1(){
        return "ERROR";
   }
}
