package by.bsuir.dashka.repository;

import by.bsuir.dashka.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dashka on 26.04.2015.
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
