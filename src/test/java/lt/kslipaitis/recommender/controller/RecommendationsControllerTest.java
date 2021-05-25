package lt.kslipaitis.recommender.controller;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;
import lt.kslipaitis.recommender.model.recommendation.ProductDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import lt.kslipaitis.recommender.service.QuestionnaireAnswersMapper;
import lt.kslipaitis.recommender.service.RecommendationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendationsController.class)
class RecommendationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecommendationsService service;

    @MockBean
    private QuestionnaireAnswersMapper mapper;

    @Test
    void recommendations() throws Exception {
        QuestionnaireAnswers answers = new QuestionnaireAnswers(AgeOption.YOUTH, StudentOption.YES, IncomeOption.LOW);

        when(mapper.map(any(QuestionnaireAnswersDTO.class)))
                .thenReturn(answers);

        when(service.getRecommendations(answers))
                .thenReturn(new Recommendations(singletonList(new ProductDTO("test-product-name"))));

        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("age", "test-age");
        requestParams.add("student", "test-student");
        requestParams.add("income", "test-income");

        mockMvc.perform(get("/api/recommendations")
                .params(requestParams))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products", hasSize(1)))
                .andExpect(jsonPath("$.products[*].name", containsInAnyOrder("test-product-name")));
    }
}