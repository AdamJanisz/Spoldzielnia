package pl.dmcs.ajanisz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.dao.AddressRepository;
import pl.dmcs.ajanisz.domain.Address;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

  @Autowired
  AddressRepository addressRepository;

  @Transactional
  public void addAddress(Address address) {
    addressRepository.save(address);
  }

  @Transactional
  public void editAddress(Address address) {
    addressRepository.save(address);
  }

  @Transactional
  public List<Address> listAddress() {
    return addressRepository.findAll();
  }

  @Transactional
  public void removeAddress(long id) {
    addressRepository.delete(id);
  }

  @Transactional
  public Address getAddress(long id) {
    return addressRepository.findById(id);
  }

  @Transactional
  public List<Address> listManagerAddress(long id) {

      List<Address> address=listAddress();
      List<Address> userAddress=new ArrayList<Address>();

      for(int i=0;i<address.size();i++){
        if(address.get(i).getOwner().getId()==id){
          userAddress.add(address.get(i));
        }
      }
      return userAddress;
    }

}
