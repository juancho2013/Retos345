package com.example.retos345.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos345.entities.Tool;
import com.example.retos345.repositories.ToolRepository;


@Service
public class ToolService {
    
        @Autowired
        private ToolRepository toolRepository;

        public ToolService(ToolRepository toolRepository) {
            this.toolRepository = toolRepository;
        }

        // METODOS CRUD
        public List<Tool> getListTools(){
            return this.toolRepository.findAll();
        }

        public Tool getTool(int id){
            if(!this.toolRepository.findById(id).isEmpty()){
                return this.toolRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Tool crearTool(Tool tool){
            return this.toolRepository.save(tool);
        }

        public void eliminarTool(int id){
            if(!this.toolRepository.findById(id).isEmpty()){
                this.toolRepository.deleteById(id);
            }
        }

        public void actualizarTool(int id, Tool tool){
            if(!this.toolRepository.findById(id).isEmpty()){
                Tool toolDB = this.toolRepository.findById(id).get();
                if(tool.getName() != null){
                    toolDB.setName(tool.getName());
                }
                if(tool.getAddress() != null){
                    toolDB.setAddress(tool.getAddress());
                }
                if(tool.getDescription() != null){
                    toolDB.setDescription(tool.getDescription());
                }
                if(tool.getExtension() != null){
                    toolDB.setExtension(tool.getExtension());
                }
                this.toolRepository.save(toolDB);
            }
        }
}
