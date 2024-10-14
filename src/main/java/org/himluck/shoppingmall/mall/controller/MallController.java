package org.himluck.shoppingmall.mall.controller;

import org.himluck.shoppingmall.mall.entities.Mall;
import org.himluck.shoppingmall.mall.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/malls")
public class MallController {

    private final MallService mallService;

    @Autowired
    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    // Get all malls
    @GetMapping
    public ResponseEntity<List<Mall>> getAllMalls() {
        List<Mall> malls = mallService.getAllMalls();
        return new ResponseEntity<>(malls, HttpStatus.OK);
    }

    // Get a specific mall by ID
    @GetMapping("/{id}")
    public ResponseEntity<Mall> getMallById(@PathVariable int id) {
        Optional<Mall> mall = mallService.getMallById(id);
        return mall.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new mall
    @PostMapping
    public ResponseEntity<Mall> createMall(@RequestBody Mall mall) {
        Mall createdMall = mallService.addMall(mall);
        return new ResponseEntity<>(createdMall, HttpStatus.CREATED);
    }

    // Update an existing mall by ID
    @PutMapping("/{id}")
    public ResponseEntity<Mall> updateMall(@PathVariable int id, @RequestBody Mall mall) {
        try {
            Mall updatedMall = mallService.updateMall(id, mall);
            return new ResponseEntity<>(updatedMall, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a mall by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMall(@PathVariable int id) {
        mallService.deleteMall(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
