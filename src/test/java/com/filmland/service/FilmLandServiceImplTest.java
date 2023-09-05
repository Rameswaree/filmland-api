package com.filmland.service;

import com.filmland.custom.LoginCustomerRequest;
import com.filmland.repository.FilmLandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Unit test for {@link FilmLandServiceImpl}
 */
@SpringJUnitConfig
public class FilmLandServiceImplTest {

    @InjectMocks
    FilmLandServiceImpl filmLandService;

    @MockBean
    private FilmLandRepository filmLandRepository;

    private LoginCustomerRequest loginCustomerRequest;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        loginCustomerRequest = new LoginCustomerRequest("test@gmail.com", "Test", "testPassword");
    }

    @Test
    void shouldSaveUser(){

        filmLandService.saveUser(loginCustomerRequest);
        verify(filmLandRepository).save(any());
    }
}