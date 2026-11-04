
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.MobileRecharge;
import com.example.demo.service.MobileRechargeService;

@RestController
@RequestMapping("/api/recharges")
public class MobileRechargeController {

    private final MobileRechargeService service;

    public MobileRechargeController(MobileRechargeService service) {
        this.service = service;
    }

    // Add Recharge
    @PostMapping
    public MobileRecharge addRecharge(
            @RequestBody MobileRecharge recharge) {
        return service.addRecharge(recharge);
    }

    // Get All Recharges
    @GetMapping
    public List<MobileRecharge> getAllRecharges() {
        return service.getAllRecharges();
    }

    // Get Recharge By ID
    @GetMapping("/{id}")
    public MobileRecharge getRechargeById(
            @PathVariable Long id) {
        return service.getRechargeById(id);
    }

    // Update Recharge
    @PutMapping("/{id}")
    public MobileRecharge updateRecharge(
            @PathVariable Long id,
            @RequestBody MobileRecharge recharge) {
        return service.updateRecharge(id, recharge);
    }

    // Delete Recharge
    @DeleteMapping("/{id}")
    public String deleteRecharge(@PathVariable Long id) {
        return service.deleteRecharge(id);
    }
}
