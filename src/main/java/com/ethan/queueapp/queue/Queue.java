package com.ethan.queueapp.queue;
import java.io.Serializable;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
// import org.springframework.web.bind.annotation.GetMapping;

@RedisHash("Queue")
public class Queue implements Serializable{
    @Id
    private Integer id;
    private Integer table;
    private String status;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTable() {
        return this.table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", table='" + getTable() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

    public Queue(Integer id, Integer table, String status) {
        this.id = id;
        this.table = table;
        this.status = status;
    }

    public Queue() {
    }

}
