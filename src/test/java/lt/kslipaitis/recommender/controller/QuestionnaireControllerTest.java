package lt.kslipaitis.recommender.controller;

import lt.kslipaitis.recommender.model.questionnaire.*;
import lt.kslipaitis.recommender.service.QuestionnaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionnaireController.class)
class QuestionnaireControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionnaireService service;

    @Test
    void questionnaireOptions_emptyOptions() throws Exception {
        when(service.getQuestionnaireOptions())
                .thenReturn(new QuestionnaireOptions(emptyList(), emptyList(), emptyList()));

        mockMvc.perform(get("/api/questionnaire/options")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ageOptions", hasSize(0)))
                .andExpect(jsonPath("$.studentOptions", hasSize(0)))
                .andExpect(jsonPath("$.incomeOptions", hasSize(0)));
    }

    @Test
    void questionnaireOptions_someOptions() throws Exception {
        List<AgeOption> ageOptions = asList(AgeOption.YOUTH, AgeOption.ADULT);
        List<StudentOption> studentOptions = singletonList(StudentOption.YES);
        List<IncomeOption> incomeOptions = asList(IncomeOption.NONE, IncomeOption.LOW, IncomeOption.HIGH);
        QuestionnaireOptions questionnaireOptions = new QuestionnaireOptions(ageOptions, studentOptions, incomeOptions);

        when(service.getQuestionnaireOptions())
                .thenReturn(questionnaireOptions);

        mockMvc.perform(get("/api/questionnaire/options")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ageOptions", hasSize(2)))
                .andExpect(jsonPath("$.ageOptions[*].name", containsInAnyOrder(
                        AgeOption.YOUTH.getName(),
                        AgeOption.ADULT.getName()
                )))
                .andExpect(jsonPath("$.studentOptions", hasSize(1)))
                .andExpect(jsonPath("$.studentOptions[*].name", containsInAnyOrder(
                        StudentOption.YES.getName()
                )))
                .andExpect(jsonPath("$.incomeOptions", hasSize(3)))
                .andExpect(jsonPath("$.incomeOptions[*].name", containsInAnyOrder(
                        IncomeOption.NONE.getName(),
                        IncomeOption.LOW.getName(),
                        IncomeOption.HIGH.getName()
                )));
    }
}