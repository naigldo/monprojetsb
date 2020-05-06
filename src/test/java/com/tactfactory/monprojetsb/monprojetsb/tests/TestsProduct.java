package com.tactfactory.monprojetsb.monprojetsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.monprojetsb.ApplicationTests;
import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.mockito.MockitoProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repository.ProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;
import com.tactfactory.monprojetsb.monprojetsb.services.ProductService;

//pour les mocks
@ActiveProfiles("test")
@TestPropertySource(locations = { "classpath:application-test.properties" })
@SpringBootTest(classes = ApplicationTests.class)

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages ="com.tactfactory.monprojetsb.monprojetsb.entities")
@ComponentScan(basePackages ="com.tactfactory.monprojet")
public class TestsProduct {

	//@Autowired
	@MockBean
    private ProductService productService;
    private UserRepository userRepository;
    private ProductRepository productRepository;


    //We have to clear the db before do the tests to make them really clear
//    @Before
//    public void clear() {
//        this.productRepository.deleteAll();
//        this.userRepository.deleteAll();
//    }

    @BeforeEach
    public void setUp() throws Exception {
	    final MockitoProductRepository mock = new MockitoProductRepository(this.productRepository);
	    mock.init();
	    this.productRepository = mock.productRepository;
    }

	public void addElement() {
		Long before = productRepository.count();
	    productService.save(new Product());
	    Long after = productRepository.count();

	    assertEquals(before + 1, after);
	}

	@Test
	public void addElementWithoutPb() {
		Product productBase = new Product(null, "Fourchette", 3f);
        Long id = productService.save(productBase).getId();
        Product productFetch = productRepository.getProductById(id);

        assertTrue(compare(productBase, productFetch));
	}

	@Test
	public void updateElementWithoutPb() {
		Product productBase = new Product(null, "Fourchette", 3f);

	}

	@Test
    public void getUserRight() {
		Product productBase = new Product(null, "Fourchette", 3f);
        Long id = productRepository.save(productBase).getId();
        Product productFetch = productService.getProductById(id);

        assertTrue(compare(productBase, productFetch));
    }

	public void getListRight(){

	}

	public void supprElementGetIncreaseTheNumber(){

	}

	public void supprElement(){

	}


	//autres méthodes
    public Boolean compare(Product p1, Product p2) {
        boolean result = true;

        if (!p1.getId().equals(p2.getId())) {
            result = false;
            System.out.println("id: " + p1.getId() + " " + p2.getId());
        }
        if (!p1.getName().equals(p2.getName())) {
            result = false;
            System.out.println("firstname: " + p1.getName() + " " + p2.getName());
        }
        if (!p1.getPrice().equals(p2.getPrice())) {
            result = false;
            System.out.println("lastname: " + p1.getPrice() + " " + p2.getPrice());
        }

        return result;
    }
}
