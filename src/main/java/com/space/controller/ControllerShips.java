package com.space.controller;

import com.space.model.Ship;
import com.space.service.ShipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ControllerShips {


    private List<Ship> shipList;

    private final ShipsService shipsService;

    public ControllerShips(ShipsService shipsService) {
        this.shipsService = shipsService;
    }

    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> index(@ModelAttribute("page") Page page) {
        shipList = shipsService.paging(page.getOrder(), page.getPageNumber(), page.getPageSize());
        System.out.println(page);
        return new ResponseEntity<>(shipList, HttpStatus.OK);
    }

    @PostMapping("/ships/{id}")
    public ResponseEntity<Ship> update(@RequestBody Ship ship,
                                       @PathVariable("id") Long id){
        return new ResponseEntity<Ship>(shipsService.update(ship, id), HttpStatus.OK);
    }

    @GetMapping("/ships/{id}")
    public ResponseEntity<Ship> show(@PathVariable("id") Long id, Model model){
        return new ResponseEntity(shipsService.show(id), HttpStatus.OK);
    }

    @GetMapping("/ships/count")
    public ResponseEntity count(@ModelAttribute("ship") Ship ship,
                                @ModelAttribute("order") Order order) {
        return new ResponseEntity<>(shipsService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/ships/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        shipsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
