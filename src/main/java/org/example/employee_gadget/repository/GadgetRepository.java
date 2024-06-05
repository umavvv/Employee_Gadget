package org.example.employee_gadget.repository;

import org.example.employee_gadget.entity.Gadget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GadgetRepository extends CrudRepository<Gadget, Long> {
}