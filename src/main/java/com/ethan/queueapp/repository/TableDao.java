package com.ethan.queueapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ethan.queueapp.table.Table;

@Repository
public class TableDao {
    @Autowired
    private RedisTemplate template;
    public static final String HASH_KEY = "Table";

    public Table save(Table table) {
        template.opsForHash().put(HASH_KEY, table.getId(), table);
        return table;
    }
    
    public List<Table> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public String remove(Integer id){
        template.opsForHash().delete(HASH_KEY, id);
        return "{message: Table removed}";
    }

    public Table update(Table table){
        template.opsForHash().put(HASH_KEY, table.getId(), table);
        return table;
    }

}
