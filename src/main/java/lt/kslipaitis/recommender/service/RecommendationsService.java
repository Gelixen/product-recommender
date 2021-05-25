package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.recommendation.ProductDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
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

    public Recommendations getRecommendations(QuestionnaireAnswers questionnaireAnswers) {

        List<Product> applicableProducts = findApplicableProducts(questionnaireAnswers);
        List<ProductDTO> applicableProductsDTO = mapToProductsDTO(applicableProducts);

        return new Recommendations(applicableProductsDTO);
    }

    private List<Product> findApplicableProducts(QuestionnaireAnswers questionnaireAnswers) {
        return products.stream()
                .filter(product -> product.doApply(questionnaireAnswers))
                .collect(Collectors.toList());
    }

    private List<ProductDTO> mapToProductsDTO(List<Product> products) {
        return products.stream()
                .map(Product::getName)
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

}
