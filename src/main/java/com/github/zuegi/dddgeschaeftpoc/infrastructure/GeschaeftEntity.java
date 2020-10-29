package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeschaeftEntity extends AbstractEntity{

    String geschaeftId;
    String beschreibung;

    public GeschaeftEntity(Geschaeft geschaeft) {
        this.geschaeftId = geschaeft.id().value();
        this.beschreibung = geschaeft.geschaeftHandle().value();
    }

}
