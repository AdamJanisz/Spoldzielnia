package pl.dmcs.ajanisz.controller;

import org.apache.tiles.locale.LocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.ajanisz.dao.AppUserRepository;
import pl.dmcs.ajanisz.dao.BillsRepository;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.Bills;
import pl.dmcs.ajanisz.service.AddressService;
import pl.dmcs.ajanisz.service.AppUserService;
import pl.dmcs.ajanisz.service.BillsService;
//import sun.util.resources.LocaleData;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@EnableScheduling
@Controller
public class BillsController {


    @Autowired
    BillsService billsService;

    @Autowired
    AppUserService appUserService;
    @Autowired
    AppUserRepository appUserRepository;


    @Scheduled(cron="0 */1 * * * *")
    public void generateBills() {

        for (AppUser user:appUserService.listAppUser()) {
            Date date = new Date();

            SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMMM"); //month name
            String formattedDate = simpleDateformat.format(date);

            Bills bills = new Bills();
            bills.setAppUser(user);
            bills.setColdWater(100);
            bills.setHotWater(100);
            bills.setElectricity(100);
            bills.setRepairFund(100);
            bills.setSewage(100);
            bills.setDate(formattedDate);
            billsService.addBills(billsService.calculateTotalAmount(bills));
        }
    }

//    @Scheduled(cron="0 */1 * * * *")
//    public void removeBills() {
//
//        for (AppUser user:appUserService.listAppUser()) {
//
//
//            //billsService.addBills(billsService.calculateTotalAmount(bills));
//        }
//    }

    @RequestMapping(value="/bills")
    public String showBills(Model model, HttpServletRequest request){
        int billId = ServletRequestUtils.getIntParameter(request, "billsId" , -1);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String currentUserUsername = ((UserDetails) principal).getUsername();
       AppUser currentUser = appUserService.findByLogin(currentUserUsername);

        if (billId > 0) {
            if(billsService.getBills(billId).getAppUser().getLogin().equals(currentUserUsername)){
            model.addAttribute("bill", billsService.getBills(billId));
            }else{
                model.addAttribute("bill",new Bills());
            }
            model.addAttribute("serverTime",billsService.getBills(billId).getDate());
            model.addAttribute("currentUser", billsService.getBills(billId).getAppUser());
        }
            model.addAttribute("userBillsList", billsService.listUserBills(currentUser.getId()));

        return "billsManagerPage";
    }

    @RequestMapping(value = "/editBill", method = RequestMethod.POST)
    public String addBill(Authentication authentication,@ModelAttribute("bill") Bills bill, Model model)
    {
        billsService.editBills(billsService.calculateTotalAmount(bill));
        return "redirect:bills.html";
    }

}
