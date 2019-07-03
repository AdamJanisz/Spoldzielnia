package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.ajanisz.dao.AppartmentRepository;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.Appartment;
import pl.dmcs.ajanisz.domain.Bills;
import pl.dmcs.ajanisz.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


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
    public String appUserRegistration(Model model,HttpServletRequest request){


        model.addAttribute("appUser",new AppUser());
        model.addAttribute("appartmentList",appartmentService.listAppartment());

        return "appUserRegistration";
    }
    @RequestMapping(value = "/registerAppUser", method = RequestMethod.POST)
    public String registerAppUser(@ModelAttribute("appUser") AppUser appUser, Model model, HttpServletRequest request) {



        if(reCaptchaService.verify(request.getParameter("g-rechaptcha-response"))){
            appUser.setAppUserRole(appUserRoleService.getUserRole("ROLE_USER"));
            appUserService.addAppUser(appUser);

            appUser.getAppartment().setAppUser(appUser);
            appartmentRepository.save(appUser.getAppartment());

            return "redirect:registration.html";
        }
        appUser.getAppUserRole().clear();

        return "hello";
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
    public String addAppUser(@ModelAttribute("appUser") AppUser appUser, Model model) {

        if (1==1) {
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
        }
        appUser.getAppUserRole().clear();

        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("addressesList", addressService.listAddress());
        model.addAttribute("appUserRoleList",appUserRoleService.listAppUserRole());
        return "appUser";
    }

    @RequestMapping("/delete/{appUserId}")
    public String deleteUser(@PathVariable("appUserId") Long appUserId) {
        Appartment flat=appartmentService.getAppartment(appUserService.getAppUser(appUserId).getAppartment().getId());
        flat.setAppUser(null);
        appartmentRepository.save(flat);

        appUserService.removeAppUser(appUserId);
        return "redirect:/appUsers.html";
    }

}

