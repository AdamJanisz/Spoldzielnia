package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import pl.dmcs.ajanisz.dao.AppUserRoleRepository;
import pl.dmcs.ajanisz.domain.Address;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.service.AddressService;
import pl.dmcs.ajanisz.service.AppUserRoleService;
import pl.dmcs.ajanisz.service.AppUserService;
import pl.dmcs.ajanisz.validator.AddressValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AddressController {
    AddressValidator addressValidator = new AddressValidator();

        @Autowired
        private AddressService addressService;
        @Autowired
        private AppUserService appUserService;
        @Autowired
    private AppUserRoleService appUserRoleService;
    @Autowired
    private AppUserRoleRepository appUserRoleRepository;

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
    @RequestMapping(value="/Mybuildings")
    public String showMyBuildings(Model model, HttpServletRequest request){
        int addressId = ServletRequestUtils.getIntParameter(request, "addressId" , -1);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String currentUserUsername = ((UserDetails) principal).getUsername();
        AppUser currentUser = appUserService.findByLogin(currentUserUsername);

        if (addressId > 0)
            model.addAttribute("address", addressService.getAddress(addressId));
        else
            model.addAttribute("address", new Address());

        if(currentUser.getAppUserRole().contains(appUserRoleRepository.findByRole("ROLE_ADMIN")))
        model.addAttribute("addressList", addressService.listAddress());
        else
            model.addAttribute("addressList", addressService.listManagerAddress(currentUser.getId()));

        return "MybuildingPage";
    }
    @RequestMapping(value = "/editBuilding", method = RequestMethod.POST)
    public String editAddress(@ModelAttribute("address") Address address, BindingResult result)
    {
        addressValidator.validate(address,result);

        if(result.getErrorCount()==0){
            addressService.editAddress(address);
            return "redirect:Mybuildings.html";}

       return "MybuildingPage";
    }
    @RequestMapping(value="/buildingsManager")
    public String  buildingAddManager(Model model, HttpServletRequest request){
        int addressId = ServletRequestUtils.getIntParameter(request, "addressId" , -1);

        Address address = addressService.getAddress(addressId);

        model.addAttribute("address", address);



        model.addAttribute("addressList", addressService.listAddress());
        model.addAttribute("appUserList", appUserService.findByRole(appUserRoleRepository.findByRole("ROLE_MANAGER")));
        return "buildingOwners";
    }

        @RequestMapping(value = "/addBuilding", method = RequestMethod.POST)
        public String addAddress(@Valid @ModelAttribute("address") Address address, BindingResult result)
        {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String currentUserUsername = ((UserDetails) principal).getUsername();
            AppUser currentUser = appUserService.findByLogin(currentUserUsername);

            addressValidator.validate(address,result);
            if(result.getErrorCount()==0){
                if(address.getOwner()==null)
                address.setOwner(currentUser);
                addressService.editAddress(address);
            return "redirect:buildings.html";}

            return "buildingManagerPage";
    }
    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    public String addBuildingManager(@ModelAttribute("address") Address address, BindingResult result)
    {
        addressService.editAddress(address);
        return "redirect:buildings.html";
    }

    @RequestMapping("/deleteAddress/{addressId}")
    public String deleteAddress(@PathVariable("addressId") Integer addressId,Model model) {


            addressService.removeAddress(addressId);



        return "redirect:/buildings.html";
    }
}
