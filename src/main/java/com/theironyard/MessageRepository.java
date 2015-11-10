package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by macbookair on 11/10/15.
 */
public interface MessageRepository extends CrudRepository<Message,Integer> {
}
