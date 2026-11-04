
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.model.MobileRecharge;
import com.example.demo.exception.MobileRechargeNotFoundException;

@Service
public class MobileRechargeService {

    private List<MobileRecharge> rechargeList = new ArrayList<>();

    private AtomicLong idGenerator = new AtomicLong(1);

    public MobileRecharge addRecharge(MobileRecharge recharge) {
        recharge.setRechargeId(idGenerator.getAndIncrement());
        rechargeList.add(recharge);
        return recharge;
    }

    public List<MobileRecharge> getAllRecharges() {
        return rechargeList;
    }

    public MobileRecharge getRechargeById(Long id) {
        return rechargeList.stream()
                .filter(r -> r.getRechargeId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                    new MobileRechargeNotFoundException(
                        "Recharge not found with ID: " + id
                    )
                );
    }

    public MobileRecharge updateRecharge(
            Long id, MobileRecharge recharge) {

        MobileRecharge existing = getRechargeById(id);

        existing.setMobileNumber(recharge.getMobileNumber());
        existing.setOperator(recharge.getOperator());
        existing.setAmount(recharge.getAmount());
        existing.setPlanType(recharge.getPlanType());

        return existing;
    }

    public String deleteRecharge(Long id) {

        MobileRecharge recharge = getRechargeById(id);
        rechargeList.remove(recharge);

        return "Recharge deleted successfully";
    }
}
