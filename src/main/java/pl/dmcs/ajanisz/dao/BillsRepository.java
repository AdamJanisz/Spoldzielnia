package pl.dmcs.ajanisz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dmcs.ajanisz.domain.Bills;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BillsRepository extends JpaRepository<Bills,Long> {

    Bills findById(long id);

    @Modifying
    @Transactional
    @Query(value = "update Bills set coldWater= :cold,hotWater=500,sewage=500,electricity=0,repairFund=0 where id= :billId")
    void updateBill(@Param("cold") int cold,@Param("billId")long billId);
    Bills getBillsById(long id);




}
