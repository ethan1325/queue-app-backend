package com.ethan.queueapp.table;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
// import org.springframework.web.bind.annotation.GetMapping;

@RedisHash("Table")
public class Table implements Serializable {
    @Id
    private Integer id;
    private Integer queue_id;
    private String teller;
    private String status;
    private Integer time;


    public Table() {
    }
   

    public Table(Integer id, Integer queue_id, String teller, String status, Integer time) {
        this.id = id;
        this.queue_id = queue_id;
        this.teller = teller;
        this.status = status;
        this.time = time;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQueue_id() {
        return this.queue_id;
    }

    public void setQueue_id(Integer queue_id) {
        this.queue_id = queue_id;
    }

    public String getTeller() {
        return this.teller;
    }

    public void setTeller(String teller) {
        this.teller = teller;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", queue_id='" + getQueue_id() + "'" +
            ", teller='" + getTeller() + "'" +
            ", status='" + getStatus() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }
    
}
