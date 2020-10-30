package com.github.zuegi.dddgeschaeftpoc.application.rest;

import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.service.DomainGeschaeftService;
import com.github.zuegi.dddgeschaeftpoc.domain.service.GeschaeftService;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.JdbcGeschaeftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/public/geschaeft")
public class GeschaeftResource {


    private GeschaeftService geschaeftService;

    public GeschaeftResource(JdbcGeschaeftRepository jdbcGeschaeftRepository) {
        this.geschaeftService = new DomainGeschaeftService(jdbcGeschaeftRepository);
    }


    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeschaeftIdentifier> saveGeschaeft(@RequestParam String beschreibung) {

        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle("Übergrosser Bildschirm");
        Preis preis = new Preis(new BigDecimal("1238.60"), Currency.CHF);

        GeschaeftIdentifier geschaeft = this.geschaeftService.createGeschaeft(geschaeftHandle, preis);
        return ResponseEntity.ok(geschaeft);
    }

}
