package lt.kslipaitis.recommender.controller;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import lt.kslipaitis.recommender.service.RecommendationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    public RecommendationsController(RecommendationsService recommendationsService) {
        this.recommendationsService = recommendationsService;
    }

    @GetMapping
    public Recommendations getRecommendations(QuestionnaireAnswersDTO questionnaireAnswersDTO) {
        return recommendationsService.getRecommendations(questionnaireAnswersDTO);
    }

}
