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
import pl.dmcs.ajanisz.domain.Address;
import pl.dmcs.ajanisz.service.AddressService;
import pl.dmcs.ajanisz.service.AppUserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddressController {

        @Autowired
        private AddressService addressService;
        @Autowired
        private AppUserService appUserService;

        @RequestMapping(value="/buildings")
        public String showBuildings(Model model, HttpServletRequest request){
            int addressId = ServletRequestUtils.getIntParameter(request, "addressId" , -1);

            if (addressId > 0)
                model.addAttribute("address", addressService.getAddress(addressId));
            else
                model.addAttribute("address", new Address());

            model.addAttribute("addressList", addressService.listAddress());
            return "buildingManagerPage";
        }

        @RequestMapping(value = "/addBuilding", method = RequestMethod.POST)
        public String addAddress(@ModelAttribute("address") Address address, BindingResult result)
        {
            if (address.getId()==0)
                addressService.addAddress(address);
            else
                addressService.editAddress(address);
            return "redirect:buildings.html";
    }

    @RequestMapping("/deleteAddress/{addressId}")
    public String deleteAddress(@PathVariable("addressId") Integer addressId,Model model) {
        int flag=0;
//        for(int i=0;i<appUserService.listAppUser().size();i++) {
//            if(appUserService.getAppUser(appUserService.listAppUser().get(i).getId()).getAppartment().getAddress().getId()==addressService.getAddress(addressId).getId()){
//                flag=1;}
//        }

        if(flag==0) {
            addressService.removeAddress(addressId);

        }
        else{
            model.addAttribute("deleteError","Address ma przypisanych użytkowników");
            return "operationNotAllowed";}

        return "redirect:/buildings.html";
    }
}
