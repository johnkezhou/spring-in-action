package chapter5.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import chapter5.base.Spitter;
import chapter5.base.Spittle;
import chapter5.data.ISpitterRepository;
import chapter5.data.ISpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/28.
 */
public class SpitterControllerTest {

    private ISpitterRepository spitterRepository;
    private SpitterController spitterController;
    private MockMvc mockMvc;
    public SpitterControllerTest() {
        spitterRepository = mock(ISpitterRepository.class);
        spitterController = new SpitterController(spitterRepository);
        mockMvc = standaloneSetup(spitterController).build();
    }

    @Test
    public void testShowRegistrationForm() throws Exception{

        MockMvc mockMvc = standaloneSetup(spitterController).build();
        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }

    @Test
    public void testProcessRegistration() throws Exception{

        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "dande@zju.com");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "dande@zju.com");
        when(spitterRepository.save(unsaved)).thenReturn(saved);

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("email", "dande@zju.com"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(spitterRepository, atLeastOnce()).save(unsaved);
    }

    @Test
    public void testFailValidationWithNoData() throws Exception{
        mockMvc.perform(post("/spitter/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"))
                .andExpect(model().errorCount(5))
                .andExpect(model().attributeHasErrors("spitter", "firstName", "lastName", "username", "password", "email"));
    }
}