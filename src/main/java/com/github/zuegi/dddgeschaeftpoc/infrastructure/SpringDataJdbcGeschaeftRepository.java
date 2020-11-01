package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataJdbcGeschaeftRepository extends CrudRepository<GeschaeftEntity, Long> {

    GeschaeftEntity findByGeschaeftId(String geschaeftIdentifier);
}
