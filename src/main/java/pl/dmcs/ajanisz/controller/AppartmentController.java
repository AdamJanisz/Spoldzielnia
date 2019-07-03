package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.ajanisz.domain.Appartment;
import pl.dmcs.ajanisz.service.AddressService;
import pl.dmcs.ajanisz.service.AppUserService;
import pl.dmcs.ajanisz.service.AppartmentService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppartmentController {


        @Autowired
        private AppartmentService appartmentService;

        @Autowired
        private AddressService addressService;
        @Autowired
        private AppUserService appUserService;


        @RequestMapping(value="/appartments")
        public String showBuildings(Model model, HttpServletRequest request){
            int appartmentId = ServletRequestUtils.getIntParameter(request, "appartmentId" , -1);


        if (appartmentId > 0) {
        Appartment appartment= appartmentService.getAppartment(appartmentId);
        }else { model.addAttribute("appartment", new Appartment());
        }
                model.addAttribute("appartmentList", appartmentService.listAppartment());
                model.addAttribute("addressList", addressService.listAddress());
                model.addAttribute("appUserList", appUserService.listAppUser());


            return "appartmentsManagerPage";
        }


        @RequestMapping(value = "/addAppartment", method = RequestMethod.POST)
        public String addAppartment(@ModelAttribute("appartment") Appartment appartment, Model model)
        {

                        //   appUser.setAppUserRole(appUserRoleService.getUserRole("ROLE_USER"));
                        appartmentService.addAppartment(appartment);



            return "redirect:appartments.html";
        }

        @RequestMapping("/safeDeleteAppartment/{appartmentId}")
        public String deleteAppartment(@PathVariable("appartmentId") Long appartmentId, Model model) {
                int flag=0;
                for(int i=0;i<appUserService.listAppUser().size();i++) {
                        if(appUserService.getAppUser(appUserService.listAppUser().get(i).getId()).getAppartment().getId()==appartmentService.getAppartment(appartmentId).getId()){
                        flag=1;}
                }

                if(flag==0) {
                        appartmentService.removeAppartment(appartmentId);

                }
                else{
                        model.addAttribute("deleteError","Mieszkanie ma przypisanych użytkowników");
                        return "operationNotAllowed";}

                return "redirect:/appartments.html";
        }
        @RequestMapping("/deleteAppartment/{appartmentId}")
        public String safeDeleteAppartment(@PathVariable("appartmentId") Long appartmentId, Model model) {

                        appartmentService.removeAppartment(appartmentId);

                return "redirect:/appartments.html";
        }




}
