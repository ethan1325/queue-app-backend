package com.ethan.queueapp.queue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethan.queueapp.repository.QueueDao;

@Service
public class QueueService {
    @Autowired
    private QueueDao dao;

    public List<Queue> getQueue() {
        return dao.findAll();
    }

    public Queue saveQueue(Queue queue) {
        return this.dao.save(queue);
    }

    public Queue updateQueue(Queue queue){
        return this.dao.updateQueue(queue);
    }

    public Queue findQueue(Integer id){
        return this.dao.findQueueById(id);
    }

    public String removeQueue(Integer id){
        return this.dao.deleteQueue(id);
    }

    public String removeAll(){
        return this.dao.removeAll();
    }
}
