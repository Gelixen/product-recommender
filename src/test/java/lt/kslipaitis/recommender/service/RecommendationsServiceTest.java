package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;
import lt.kslipaitis.recommender.model.recommendation.ProductDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import lt.kslipaitis.recommender.model.recommendation.product.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecommendationsServiceTest {

    private final RecommendationsService recommendationsService = new RecommendationsService();

    @Test
    void getRecommendations() {
        QuestionnaireAnswers answers = new QuestionnaireAnswers(
                AgeOption.ADULT,
                StudentOption.YES,
                IncomeOption.HIGH
        );
        List<String> expectedProductsName = List.of(
                new CurrentAccount().getName(),
                new CurrentAccountPlus().getName(),
                new StudentAccount().getName(),
                new CreditCard().getName(),
                new GoldCreditCard().getName()
        );

        Recommendations recommendations = recommendationsService.getRecommendations(answers);

        assertNotNull(recommendations);
        assertEquals(5, recommendations.getProducts().size());
        assertThat(recommendations.getProducts())
                .extracting(ProductDTO::getName)
                .containsExactlyInAnyOrderElementsOf(expectedProductsName);
    }
}