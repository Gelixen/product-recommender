package lt.kslipaitis.recommender;

import lt.kslipaitis.recommender.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductRecommenderApplicationTests {

	@Autowired
	private MainController mainController;
	
	@Test
	void contextLoads() {
		assertThat(mainController).isNotNull();
	}

}
