package com.space.controller;

import com.space.dao.DAOController;
import com.space.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ControllerShips {

    private final DAOController daoController;
    private List<Ship> shipList;

    @Autowired
    public ControllerShips(DAOController daoController) {
        this.daoController = daoController;
    }

    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> index() {
        shipList = daoController.index();
        return new ResponseEntity<>(shipList, HttpStatus.OK);
    }
    @PostMapping("/ships/{id}")
    public ResponseEntity<Ship> update(@RequestBody Ship ship,
                                       @PathVariable("id") Long id){
        return new ResponseEntity<Ship>(daoController.update(ship, id), HttpStatus.OK);
    }

    @GetMapping("/ships/{id}")
    public ResponseEntity<Ship> show(@PathVariable("id") Long id, Model model){
        return new ResponseEntity(daoController.show(id), HttpStatus.OK);
    }

    @GetMapping("/ships/count")
    public ResponseEntity count(@ModelAttribute("ship") Ship ship) {

        return new ResponseEntity<>(shipList.size(), HttpStatus.OK);
    }
    @DeleteMapping("/ships/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        daoController.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
