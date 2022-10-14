package com.example.retos345.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos345.entities.Tool;
import com.example.retos345.services.ToolService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Tool")
public class ToolController {    

    @Autowired
    ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tool>> getTools(){
        return new ResponseEntity<List<Tool>>(this.toolService.getListTools(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tool> getTool(@PathVariable("id") int id){
        return new ResponseEntity<Tool>(this.toolService.getTool(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Tool> crearTool(@RequestBody Tool tool){
        this.toolService.crearTool(tool);
        return new ResponseEntity<Tool>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  eliminarTool(@PathVariable("id") int id){
        this.toolService.eliminarTool(id);
        return new ResponseEntity<String>("Tools eliminado",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<String>  actualizarTool(@RequestBody Tool tool){
        this.toolService.actualizarTool(tool.getId(), tool);
        return new ResponseEntity<String>("Tool actualizado", HttpStatus.CREATED);
    }
    

}
