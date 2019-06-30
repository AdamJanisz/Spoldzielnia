package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.Appartment;
import pl.dmcs.ajanisz.service.AddressService;
import pl.dmcs.ajanisz.service.AppUserRoleService;
import pl.dmcs.ajanisz.service.AppUserService;
import pl.dmcs.ajanisz.service.AppartmentService;

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


    @RequestMapping(value = "/appUsers")
    public String showAppUsers(Model model, HttpServletRequest request) {


        int appUserId = ServletRequestUtils.getIntParameter(request, "appUserId" , -1);

        if (appUserId > 0) {
            AppUser appUser = appUserService.getAppUser(appUserId);
            appUser.setPassword("");
            appUser.setAppartment((appartmentService.getAppartment(appUserService.getAppUser(appUserId).getAppartment().getId())));
            model.addAttribute("selectedAppartment",appUserService.getAppUser(appUserId).getAppartment().getId());
//            appUser.setAddress((addressService.getAddress(appUserService.getAppUser(appUserId).getAddress().getId())));
//            model.addAttribute("selectedAddress",appUserService.getAppUser(appUserId).getAddress().getId());
            model.addAttribute("selectedAppartment",appUserService.getAppUser(appUserId).getAppartment().getId());
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
             //   appUser.setAppUserRole(appUserRoleService.getUserRole("ROLE_USER"));
                appUserService.addAppUser(appUser);
            }
            else
                appUserService.editAppUser(appUser);

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
        appUserService.removeAppUser(appUserId);
        return "redirect:/appUsers.html";
    }

}

