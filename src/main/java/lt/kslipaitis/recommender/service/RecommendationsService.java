package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.recommendation.Product;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class RecommendationsService {
    
    public Recommendations getRecommendations(QuestionnaireAnswers questionnaireAnswers) {
        return new Recommendations(
                asList(
                        new Product("Current Account"),
                        new Product("Current Account Plus"),
                        new Product("Junior Saver Account"),
                        new Product("Student Account"),
                        new Product("Senior Account"),
                        new Product("Debit Card"),
                        new Product("Credit Card"),
                        new Product("Gold Credit Card")
                )
        );
    }

}
