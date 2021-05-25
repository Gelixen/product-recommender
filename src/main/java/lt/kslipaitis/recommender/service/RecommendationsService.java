package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.recommendation.product.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationsService {

    private final List<Product> products = List.of(
            new CurrentAccount(),
            new CurrentAccountPlus(),
            new JuniorSaverAccount(),
            new StudentAccount(),
            new SeniorAccount(),
            new DebitCard(),
            new CreditCard(),
            new GoldCreditCard()
    );

    public List<Product> getApplicableProducts(QuestionnaireAnswers questionnaireAnswers) {
        return filterApplicableProducts(questionnaireAnswers);
    }

    private List<Product> filterApplicableProducts(QuestionnaireAnswers questionnaireAnswers) {
        return products.stream()
                .filter(product -> product.doApply(questionnaireAnswers))
                .collect(Collectors.toList());
    }

}
