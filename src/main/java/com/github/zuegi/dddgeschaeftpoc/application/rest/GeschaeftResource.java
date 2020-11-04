package com.github.zuegi.dddgeschaeftpoc.application.rest;

import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.UserRepository;
import com.github.zuegi.dddgeschaeftpoc.domain.service.ErstelleGeschaeftService;
import com.github.zuegi.dddgeschaeftpoc.domain.service.GeschaeftService;
import com.github.zuegi.dddgeschaeftpoc.domain.user.FirstName;
import com.github.zuegi.dddgeschaeftpoc.domain.user.LastName;
import com.github.zuegi.dddgeschaeftpoc.domain.user.User;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.JdbcGeschaeftRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/geschaeft")
public class GeschaeftResource {


    private GeschaeftService geschaeftService;

    User anbieter = User.newUser(FirstName.firstName("Hampi"), LastName.lastName("Stamm"));
    User konsument = User.newUser(FirstName.firstName("Stefan"), LastName.lastName("Räber"));

    public GeschaeftResource(JdbcGeschaeftRepository jdbcGeschaeftRepository) {
        this.geschaeftService = new ErstelleGeschaeftService(jdbcGeschaeftRepository, new UserRepository());
    }

    @ApiOperation(value = "Starte eine neues Geschaeft", response = String.class)
    @PostMapping(value = "/create")
    public ResponseEntity<String> createGeschaeft(
            @ApiParam(value = "Gib eine Beschreibung des neuen Geschaefts ein", required = true) @RequestBody GeschaeftUI geschaeftUI) {

        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(geschaeftUI.getBeschreibung());
        Preis preis = new Preis(geschaeftUI.getBetrag(), geschaeftUI.getCurrency());

        GeschaeftIdentifier geschaeft = this.geschaeftService.createGeschaeft(anbieter.userId().value(), konsument.userId().value(),geschaeftHandle, preis);
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
