package lt.kslipaitis.recommender.controller;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import lt.kslipaitis.recommender.service.QuestionnaireAnswersMapper;
import lt.kslipaitis.recommender.service.RecommendationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return recommendationsService.getRecommendations(questionnaireAnswers);
    }

}
