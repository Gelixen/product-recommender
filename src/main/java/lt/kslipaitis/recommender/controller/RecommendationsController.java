package lt.kslipaitis.recommender.controller;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.recommendation.ProductDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import lt.kslipaitis.recommender.model.recommendation.product.Product;
import lt.kslipaitis.recommender.service.QuestionnaireAnswersMapper;
import lt.kslipaitis.recommender.service.RecommendationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationsController {

    private final RecommendationsService recommendationsService;
    private final QuestionnaireAnswersMapper questionnaireAnswersMapper;

    public RecommendationsController(RecommendationsService recommendationsService,
                                     QuestionnaireAnswersMapper questionnaireAnswersMapper) {

        this.recommendationsService = recommendationsService;
        this.questionnaireAnswersMapper = questionnaireAnswersMapper;
    }

    @GetMapping
    public Recommendations getRecommendations(QuestionnaireAnswersDTO questionnaireAnswersDTO) {
        QuestionnaireAnswers questionnaireAnswers = questionnaireAnswersMapper.map(questionnaireAnswersDTO);

        List<Product> applicableProducts = recommendationsService.getApplicableProducts(questionnaireAnswers);

        return new Recommendations(mapToProductsDTO(applicableProducts));
    }

    private List<ProductDTO> mapToProductsDTO(List<Product> products) {
        return products.stream()
                .map(Product::getName)
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

}
