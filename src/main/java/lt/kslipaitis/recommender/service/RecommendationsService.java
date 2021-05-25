package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.recommendation.ProductDTO;
import lt.kslipaitis.recommender.model.recommendation.Recommendations;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class RecommendationsService {

    public Recommendations getRecommendations(QuestionnaireAnswersDTO questionnaireAnswersDTO) {
        return new Recommendations(
                asList(
                        new ProductDTO("Current Account"),
                        new ProductDTO("Current Account Plus"),
                        new ProductDTO("Junior Saver Account"),
                        new ProductDTO("Student Account"),
                        new ProductDTO("Senior Account"),
                        new ProductDTO("Debit Card"),
                        new ProductDTO("Credit Card"),
                        new ProductDTO("Gold Credit Card")
                )
        );
    }

}
