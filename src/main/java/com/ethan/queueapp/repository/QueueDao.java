package com.ethan.queueapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ethan.queueapp.queue.Queue;

@Repository
public class QueueDao {
    @Autowired
    private RedisTemplate template;
    public static final String HASH_KEY = "Queue";

    public Queue save(Queue queue) {
        List<Queue> queueList = template.opsForHash().values(HASH_KEY);

        Integer lastQueueId = 0;

        if (!queueList.isEmpty()) {
            for (Queue queue2 : queueList) {
                if (queue2.getId() >= lastQueueId) {
                    lastQueueId = queue2.getId();
                }
            }
        }

        Integer nextQueueId = lastQueueId + 1;

        queue.setId(nextQueueId);

        template.opsForHash().put(HASH_KEY, nextQueueId, queue);

        return queue;
    }

    public Queue updateQueue(Queue queue) {
        template.opsForHash().put(HASH_KEY, queue.getId(), queue);
        return queue;
    }
    
    public List<Queue> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Queue findQueueById(Integer id) {
        return (Queue) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteQueue(Integer id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "{message: Queue removed}";
    }

    public String removeAll() {
        template.getConnectionFactory().getConnection().flushAll();
        return "Flush success!";
    }
}
