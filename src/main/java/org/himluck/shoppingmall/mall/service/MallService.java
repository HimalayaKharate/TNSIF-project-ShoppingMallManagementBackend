package org.himluck.shoppingmall.mall.service;

import org.himluck.shoppingmall.mall.entities.Mall;
import org.himluck.shoppingmall.mall.repositories.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MallService {

    private final MallRepository mallRepository;

    @Autowired
    public MallService(MallRepository mallRepository) {
        this.mallRepository = mallRepository;
    }

    // Get all malls
    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    // Get a specific mall by ID
    public Optional<Mall> getMallById(int id) {
        return mallRepository.findById(id);
    }

    // Add a new mall
    public Mall addMall(Mall mall) {
        return mallRepository.save(mall);
    }

    // Update an existing mall
    public Mall updateMall(int id, Mall newMall) {
        return mallRepository.findById(id)
                .map(mall -> {
                    mall.setName(newMall.getName());
                    mall.setAddress(newMall.getAddress());
                    mall.setOwner(newMall.getOwner());
                    mall.setShops(newMall.getShops());
                    return mallRepository.save(mall);
                })
                .orElseThrow(() -> new RuntimeException("Mall not found with id: " + id));
    }

    // Delete a mall
    public void deleteMall(int id) {
        mallRepository.deleteById(id);
    }
}
