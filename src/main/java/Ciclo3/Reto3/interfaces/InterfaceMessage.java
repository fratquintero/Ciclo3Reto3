package Ciclo3.Reto3.interfaces;

import Ciclo3.Reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceMessage extends CrudRepository<Message,Integer> {
}
