package com.ethan.queueapp.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.queueapp.repository.QueueDao;

@RestController
@RequestMapping("/table")
public class TableController {
    
    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }
   
    @PostMapping()
    public Table saveQueue(@RequestBody Table table){
        return this.tableService.saveTable(table);
    }

    @GetMapping()
    public List<Table> getTables(){
        return this.tableService.getTables();
    }

}
