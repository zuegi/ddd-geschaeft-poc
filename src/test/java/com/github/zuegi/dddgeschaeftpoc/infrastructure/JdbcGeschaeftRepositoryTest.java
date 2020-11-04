package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.TestHelper;
import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.user.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class JdbcGeschaeftRepositoryTest {

    private SpringDataJdbcGeschaeftRepository springDataJdbcGeschaeftRepository;
    private JdbcGeschaeftRepository jdbcGeschaeftRepository;
    UserId anbieterId;
    UserId konsumentId;
    @BeforeEach
    void setUp() {
        springDataJdbcGeschaeftRepository = mock(SpringDataJdbcGeschaeftRepository.class);

        jdbcGeschaeftRepository = new JdbcGeschaeftRepository(springDataJdbcGeschaeftRepository);
        anbieterId = UserId.newUserId();
        konsumentId = UserId.newUserId();
    }


    @Test
    void createGeschaeft() {

        Geschaeft geschaeft = Geschaeft.newGeschaeft(anbieterId.value(), konsumentId.value(),GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E),
                new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF));
        this.jdbcGeschaeftRepository.add(geschaeft);

        verify(springDataJdbcGeschaeftRepository).save(any(GeschaeftEntity.class));
    }

    @Test
    void updateGeschaeft() {
        // given
        Geschaeft geschaeft = Geschaeft.newGeschaeft(anbieterId.value(), konsumentId.value(), GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E),
                new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF));
        GeschaeftEntity geschaeftEntity = new GeschaeftEntity(geschaeft);
        when(springDataJdbcGeschaeftRepository.findByGeschaeftId(any(String.class))).thenReturn(geschaeftEntity);

        // when
        this.jdbcGeschaeftRepository.add(geschaeft);
        // then
        verify(springDataJdbcGeschaeftRepository).save(any(GeschaeftEntity.class));
    }

}
