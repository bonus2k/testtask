package com.space.controller;

import com.space.model.Ship;
import com.space.model.ShipType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class ControllerShips {
    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> index(Model model){
        List<Ship> shipList = new ArrayList<>();
        Ship ship = new Ship(1L, "dsfs", "sdfsdf", ShipType.MILITARY, new Date(), true, 2.2, 4, 5.0);
        //model.addAttribute("container", ));
        shipList.add(ship);
        return new ResponseEntity<>(shipList, HttpStatus.OK);
        //return "/index";
    }
    @GetMapping("/ships/count")
    public ResponseEntity count(Model model){

        return new ResponseEntity<>(1, HttpStatus.OK);
        //return "/index";
    }

}
