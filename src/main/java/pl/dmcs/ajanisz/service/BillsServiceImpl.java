package pl.dmcs.ajanisz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.dao.BillsRepository;
import pl.dmcs.ajanisz.domain.Bills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class BillsServiceImpl implements BillsService{
    @Autowired
    BillsRepository billsRepository;

    @Transactional
    public List<Bills> listBills() {
        return billsRepository.findAll();
    }


    @Transactional
    public List<Bills> listUserBills(long id) {
        List<Bills> bills=listBills();
        List<Bills> userBills=new ArrayList<Bills>();

        for(int i=0;i<bills.size();i++){
            if(bills.get(i).getAppUser().getId()==id){
                userBills.add(bills.get(i));
            }
        }
        bills.clear();
        Bills[] array = userBills.toArray(new Bills[0]);
        array=sortujRosnaco(array);
        bills.addAll(Arrays.asList(array));
        return bills;

    }

    @Transactional
    public List<Bills> listManagerBills(long id) {
        List<Bills> bills=listBills();
        List<Bills> userBills=new ArrayList<Bills>();

        for(int i=0;i<bills.size();i++){
            if(bills.get(i).getAppUser().getAppartment().getAppartmentAddress().getOwner().getId()==id){
                userBills.add(bills.get(i));
            }
        }
        bills.clear();
        Bills[] array = userBills.toArray(new Bills[0]);
        array=sortujRosnaco(array);
        bills.addAll(Arrays.asList(array));
        return bills;
    }

    @Transactional
    public void addBills(Bills bills) {
        billsRepository.save(bills);
    }

    @Override
    public void editBills(Bills bills) {
        billsRepository.save(bills);
    }

    @Transactional
    public Bills getBills(long id) {
        return billsRepository.findById(id);
    }

    @Transactional
    public void removeBill(long id) {
        billsRepository.delete(id);
    }

    @Transactional
    public Bills calculateTotalAmount(Bills bill) {

        int sum=  bill.getColdWater()  * bill.getAppUser().getAppartment().getAppartmentAddress().getColdWaterPrice()  +
                  bill.getHotWater()   * bill.getAppUser().getAppartment().getAppartmentAddress().getHotWaterPrice()   +
                  bill.getElectricity()* bill.getAppUser().getAppartment().getAppartmentAddress().getElectricityPrice()+
                  bill.getRepairFund() * bill.getAppUser().getAppartment().getAppartmentAddress().getRepairFundPrice() +
                  bill.getSewage()     * bill.getAppUser().getAppartment().getAppartmentAddress().getSewagePrice();

       bill.setTotalAmount(sum);
        return bill;
    }

    @Transactional
    public void updateBill(int coldWater,long id) {
        billsRepository.updateBill(coldWater,id);
    }

    public static Bills[] sortujRosnaco(Bills[] bill) {

        Bills[] tab = new Bills[bill.length];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = bill[i];
        }
        int n = tab.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tab[j].getId() > tab[j + 1].getId()) {

                    Bills temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                }
            }
        }
        return tab;
    }

}
