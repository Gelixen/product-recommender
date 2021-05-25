package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;
import lt.kslipaitis.recommender.model.recommendation.product.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RecommendationsServiceTest {

    private final RecommendationsService recommendationsService = new RecommendationsService();

    @Test
    void getRecommendations() {
        QuestionnaireAnswers answers = QuestionnaireAnswers.builder()
                .age(AgeOption.ADULT)
                .student(StudentOption.YES)
                .income(IncomeOption.HIGH)
                .build();

        List<String> expectedProductsName = List.of(
                new CurrentAccount().getName(),
                new CurrentAccountPlus().getName(),
                new StudentAccount().getName(),
                new CreditCard().getName(),
                new GoldCreditCard().getName()
        );

        List<Product> products = recommendationsService.getApplicableProducts(answers);

        assertEquals(5, products.size());
        assertThat(products)
                .extracting(Product::getName)
                .containsExactlyInAnyOrderElementsOf(expectedProductsName);
    }
}