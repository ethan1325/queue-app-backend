package com.ethan.queueapp.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethan.queueapp.repository.TableDao;

@Service
public class TableService {
    @Autowired
    private TableDao dao;

    public Table saveTable(Table table) {
        return this.dao.save(table);
    }

    public List<Table> getTables() {
        return dao.findAll();
    }
}
