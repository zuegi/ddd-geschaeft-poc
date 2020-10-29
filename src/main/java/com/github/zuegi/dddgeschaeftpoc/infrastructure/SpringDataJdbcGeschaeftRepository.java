package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SpringDataJdbcGeschaeftRepository extends CrudRepository<GeschaeftEntity, Long> {
}
