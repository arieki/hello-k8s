package id.talentia.hellok8s.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import id.talentia.hellok8s.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {

}