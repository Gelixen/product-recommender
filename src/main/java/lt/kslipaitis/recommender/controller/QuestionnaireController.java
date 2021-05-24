package lt.kslipaitis.recommender.controller;

import lt.kslipaitis.recommender.model.questionnaire.QuestionnaireOptions;
import lt.kslipaitis.recommender.service.QuestionnaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireOptionsService;

    public QuestionnaireController(QuestionnaireService questionnaireOptionsService) {
        this.questionnaireOptionsService = questionnaireOptionsService;
    }

    @GetMapping("/options")
    public QuestionnaireOptions getQuestionnaireOptions() {
        return questionnaireOptionsService.getQuestionnaireOptions();
    }

}
