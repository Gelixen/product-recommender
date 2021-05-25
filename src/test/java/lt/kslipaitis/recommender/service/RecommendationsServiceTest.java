package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;
import lt.kslipaitis.recommender.model.recommendation.product.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static lt.kslipaitis.recommender.model.questionnaire.AgeOption.ADULT;
import static lt.kslipaitis.recommender.model.questionnaire.AgeOption.SENIOR;
import static lt.kslipaitis.recommender.model.questionnaire.AgeOption.YOUTH;
import static lt.kslipaitis.recommender.model.questionnaire.IncomeOption.*;
import static lt.kslipaitis.recommender.model.questionnaire.StudentOption.NO;
import static lt.kslipaitis.recommender.model.questionnaire.StudentOption.YES;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RecommendationsServiceTest {

    private final RecommendationsService recommendationsService = new RecommendationsService();

    private static Stream<Arguments> getRecommendations() {
        return Stream.of(
                Arguments.of(YOUTH, NO, NONE, singletonList(new JuniorSaverAccount())),
                Arguments.of(YOUTH, NO, LOW, singletonList(new JuniorSaverAccount())),
                Arguments.of(YOUTH, NO, MID, singletonList(new JuniorSaverAccount())),
                Arguments.of(YOUTH, NO, HIGH, singletonList(new JuniorSaverAccount())),
                
                Arguments.of(YOUTH, YES, NONE, singletonList(new JuniorSaverAccount())),
                Arguments.of(YOUTH, YES, LOW, singletonList(new JuniorSaverAccount())),
                Arguments.of(YOUTH, YES, MID, singletonList(new JuniorSaverAccount())),
                Arguments.of(YOUTH, YES, HIGH, singletonList(new JuniorSaverAccount())),

                Arguments.of(ADULT, NO, NONE, singletonList(new DebitCard())),
                Arguments.of(ADULT, NO, LOW, asList(new CurrentAccount(), new DebitCard())),
                Arguments.of(ADULT, NO, MID, asList(new CurrentAccount(), new CreditCard())),
                Arguments.of(ADULT, NO, HIGH, asList(new CurrentAccount(), new CurrentAccountPlus(), new CreditCard(), new GoldCreditCard())),

                Arguments.of(ADULT, YES, NONE, asList(new StudentAccount(), new DebitCard())),
                Arguments.of(ADULT, YES, LOW, asList(new CurrentAccount(), new StudentAccount(), new DebitCard())),
                Arguments.of(ADULT, YES, MID, asList(new CurrentAccount(), new StudentAccount(), new CreditCard())),
                Arguments.of(ADULT, YES, HIGH, asList(new CurrentAccount(), new CurrentAccountPlus(), new StudentAccount(), new CreditCard(), new GoldCreditCard())),
                
                Arguments.of(SENIOR, NO, NONE, asList(new SeniorAccount(), new DebitCard())),
                Arguments.of(SENIOR, NO, LOW, asList(new CurrentAccount(), new SeniorAccount(), new DebitCard())),
                Arguments.of(SENIOR, NO, MID, asList(new CurrentAccount(), new SeniorAccount(), new CreditCard())),
                Arguments.of(SENIOR, NO, HIGH, asList(new CurrentAccount(), new CurrentAccountPlus(), new SeniorAccount(), new CreditCard(), new GoldCreditCard())),

                Arguments.of(SENIOR, YES, NONE, asList(new StudentAccount(), new SeniorAccount(), new DebitCard())),
                Arguments.of(SENIOR, YES, LOW, asList(new CurrentAccount(), new StudentAccount(), new SeniorAccount(), new DebitCard())),
                Arguments.of(SENIOR, YES, MID, asList(new CurrentAccount(), new StudentAccount(), new SeniorAccount(), new CreditCard())),
                Arguments.of(SENIOR, YES, HIGH, asList(new CurrentAccount(), new CurrentAccountPlus(), new StudentAccount(), new SeniorAccount(), new CreditCard(), new GoldCreditCard()))
        );
    }

    @ParameterizedTest
    @MethodSource
    void getRecommendations(AgeOption age, StudentOption student, IncomeOption income, List<Product> expectedProducts) {
        QuestionnaireAnswers answers = QuestionnaireAnswers.builder()
                .age(age)
                .student(student)
                .income(income)
                .build();

        List<String> expectedProductsName = expectedProducts.stream()
                .map(Product::getName)
                .collect(Collectors.toList());

        List<Product> products = recommendationsService.getApplicableProducts(answers);

        assertEquals(expectedProductsName.size(), products.size());
        assertThat(products)
                .extracting(Product::getName)
                .containsExactlyInAnyOrderElementsOf(expectedProductsName);
    }
}