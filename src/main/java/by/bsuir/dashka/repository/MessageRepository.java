package by.bsuir.dashka.repository;

import by.bsuir.dashka.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dashka on 04.05.2015.
 */

public interface MessageRepository extends JpaRepository<Message, Integer> {

    public List<Message> findByIdFromAndIdTo(Integer idFrom, Integer idTo);

    public Long countByStatus(Boolean status);

}

