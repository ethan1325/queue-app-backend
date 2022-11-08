package com.ethan.queueapp.queue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {
    
    private final QueueService queueService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }
    
    @GetMapping
    public List<Queue> getQueue(){
        return this.queueService.getQueue();
    }

    @PostMapping()
    public Queue saveQueue(@RequestBody Queue queue){
        return this.queueService.saveQueue(queue);
    }

    @PostMapping("/update")
    public Queue updatequeue(@RequestBody Queue queue){
        return this.queueService.updateQueue(queue);
    }

    @GetMapping("/{id}")
    public Queue findQueue(@PathVariable Integer id){
        return this.queueService.findQueue(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Integer id){
        return this.queueService.removeQueue(id);
    }   

    @DeleteMapping()
    public String removeAll(){
        return this.queueService.removeAll();   
    }
}
