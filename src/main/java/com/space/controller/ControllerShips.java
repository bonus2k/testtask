package com.space.controller;

import com.space.model.Ship;
import com.space.service.ShipsService;
import com.space.util.UtilForShips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ControllerShips {

    private final ShipsService shipsService;

    @Autowired
    public ControllerShips(ShipsService shipsService) {
        this.shipsService = shipsService;
    }

    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> index(@ModelAttribute("Page") Page page,
                                            @ModelAttribute("Order") Order order,
                                            @RequestParam(name = "isUsed", required = false) Boolean used) {
        order.setUsed(used);
        return new ResponseEntity<>(shipsService.findByName(order, page), HttpStatus.resolve(200));
    }

    @PostMapping("/ships/{id}")
    public ResponseEntity update(@RequestBody Ship ship,
                                 @PathVariable("id") Long id) {

        ship.setId(null);

        if (id < 1 ) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else if (shipsService.show(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);}
        else if (!UtilForShips.editValidator(ship)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        else return new ResponseEntity(shipsService.update(ship, id), HttpStatus.OK);
    }

    @PostMapping("/ships/")
    public ResponseEntity create(@RequestBody Ship ship) {
        if (!UtilForShips.createValidator(ship)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        else return new ResponseEntity(shipsService.save(ship), HttpStatus.OK);
    }

    @GetMapping("/ships/{id}")
    public ResponseEntity<Ship> show(@PathVariable("id") Long id, Model model) {
        if (id < 1) {
            return new ResponseEntity(HttpStatus.valueOf(400));
        } else if (shipsService.show(id) == null) {
            return new ResponseEntity(HttpStatus.valueOf(404));
        }
        return new ResponseEntity(shipsService.show(id), HttpStatus.OK);
    }

    @GetMapping("/ships/count")
    public ResponseEntity count(@ModelAttribute("Order") Order order,
                                @RequestParam(name = "isUsed", required = false) Boolean used) {
        order.setUsed(used);
        return new ResponseEntity<>(shipsService.count(order), HttpStatus.OK);
    }

    @DeleteMapping("/ships/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (id < 1) {
            return new ResponseEntity(HttpStatus.valueOf(400));
        } else if (shipsService.show(id) == null) {
            return new ResponseEntity(HttpStatus.valueOf(404));
        }
        shipsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
