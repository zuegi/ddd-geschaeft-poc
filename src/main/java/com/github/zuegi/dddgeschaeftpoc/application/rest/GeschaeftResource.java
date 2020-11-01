package com.github.zuegi.dddgeschaeftpoc.application.rest;

import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.service.DomainGeschaeftService;
import com.github.zuegi.dddgeschaeftpoc.domain.service.GeschaeftService;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.GeschaeftEntity;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.JdbcGeschaeftRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Starte eine neues Geschaeft", response = String.class)
    @PostMapping(value = "/create")
    public ResponseEntity<String> createGeschaeft(
            @ApiParam(value = "Gib eine Beschreibung des neuen Geschaefts ein", required = true) @RequestBody GeschaeftUI geschaeftUI) {

        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(geschaeftUI.getBeschreibung());
        Preis preis = new Preis(geschaeftUI.getBetrag(), geschaeftUI.getCurrency());

        GeschaeftIdentifier geschaeft = this.geschaeftService.createGeschaeft(geschaeftHandle, preis);
        return ResponseEntity.ok("geschaeft identifier: [" + geschaeft.value() + "]");
    }

    @ApiOperation(value = "Gibt eine Geschaeft zurück", response = String.class)
    @GetMapping(value = "/{geschaeftIdentifier}")
    public ResponseEntity<GeschaeftUI> getGeschaeft(
            @ApiParam(value = "Geschaeft mit Identifier", required = true) @PathVariable String geschaeftIdentifier) {
        GeschaeftIdentifier geschaeftIdentifier1 = GeschaeftIdentifier.geschaeftIdentifier(geschaeftIdentifier);
        Geschaeft geschaeft = geschaeftService.findGeschaeftByIdentifier(geschaeftIdentifier1);
        GeschaeftUI geschaeftUI = new GeschaeftUI(geschaeft);
        return ResponseEntity.ok(geschaeftUI);
    }

}
