package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.ajanisz.dao.AppartmentRepository;
import pl.dmcs.ajanisz.domain.Address;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.Appartment;
import pl.dmcs.ajanisz.service.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    AppartmentService appartmentService;

    @Autowired
    AppUserRoleService appUserRoleService;

    @Autowired
    AddressService addressService;

    @Autowired
    BillsService billsService;
    @Autowired
    AppartmentRepository appartmentRepository;
    @Autowired
    ReCaptchaService reCaptchaService;



    @RequestMapping(value = "/registration")
    public String appUserRegistration(Model model){

        model.addAttribute("appUser",new AppUser());
        model.addAttribute("appartmentList",appartmentService.listAppartment());

        return "appUserRegistration";
    }
    @RequestMapping(value = "/registerAppUser", method = RequestMethod.POST)
    public String registerAppUser(@ModelAttribute("appUser") AppUser appUser, HttpServletRequest request) {


        if(reCaptchaService.verify(request.getParameter("g-recaptcha-response"))){
            appUser.setAppUserRole(appUserRoleService.getUserRole("ROLE_USER"));
            appUserService.addAppUser(appUser);
            appUser.getAppartment().setAppUser(appUser);
            appartmentRepository.save(appUser.getAppartment());
            return "hello";

        }
        //appUser.getAppUserRole().clear();

        return "redirect:registration.html";
    }

    @RequestMapping(value = "/appUsers")
    public String showAppUsers(Model model, HttpServletRequest request) {


        int appUserId = ServletRequestUtils.getIntParameter(request, "appUserId" ,-1);

        if (appUserId>0) {
            AppUser appUser = appUserService.getAppUser(appUserId);
            appUser.setPassword("");
            appUser.setAppartment((appartmentService.getAppartment(appUserService.getAppUser(appUserId).getAppartment().getId())));
            model.addAttribute("selectedAppartment",appUserService.getAppUser(appUserId).getAppartment().getId());
            appUser.getAppartment().setAppUser(null);
            appartmentRepository.save(appUser.getAppartment());
            model.addAttribute("appUser", appUser);



        }
        else {
            model.addAttribute("appUser",new AppUser());


        }
        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList",appUserRoleService.listAppUserRole());
        model.addAttribute("addressList",addressService.listAddress());
        model.addAttribute("appartmentList",appartmentService.listAppartment());



        return "appUser";

    }
    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@ModelAttribute("appUser") AppUser appUser, Model model, BindingResult result) {

//        if (result.getErrorCount()==0) {
            if (appUser.getId()==0) {
                appUser.setAppUserRole(appUserRoleService.getUserRole("ROLE_USER"));
                appUserService.addAppUser(appUser);

            }
            else {

                appUserService.editAppUser(appUser);

            }
            appUser.getAppartment().setAppUser(appUser);
            appartmentRepository.save(appUser.getAppartment());
            return "redirect:appUsers.html";
//        }
//        appUser.getAppUserRole().clear();
//
//        model.addAttribute("appUserList", appUserService.listAppUser());
//        model.addAttribute("addressesList", addressService.listAddress());
//        model.addAttribute("appUserRoleList",appUserRoleService.listAppUserRole());
//        return "appUser";
    }

    @RequestMapping("/delete/{appUserId}")
    public String deleteUser(@PathVariable("appUserId") Long appUserId) {
        for (Address adres:addressService.listAddress()) {
            if(adres.getOwner().getId()==appUserId){
                adres.setOwner(null);
                addressService.editAddress(adres);
            }
        }

        Appartment flat=appartmentService.getAppartment(appUserService.getAppUser(appUserId).getAppartment().getId());
        flat.setAppUser(null);
        appartmentRepository.save(flat);

        appUserService.removeAppUser(appUserId);
        return "redirect:/appUsers.html";
    }

}

