package com.tactfactory.monprojetsb.monprojetsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repository.ProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;
import com.tactfactory.monprojetsb.monprojetsb.services.UserService;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages ="com.tactfactory.monprojetsb.monprojetsb.entities")
@ComponentScan(basePackages ="com.tactfactory.monprojet")
public class TestsUser {

	@Autowired
    private UserService userService;
    private UserRepository userRepository;
    private ProductRepository productRepository;


    //We have to clear the db before do the tests to make them really clear
    @Before
    public void clear() {
        this.productRepository.deleteAll();
        this.userRepository.deleteAll();
    }

	public void addElement() {
		Long before = userRepository.count();
	    userService.save(new User());
	    Long after = userRepository.count();

	    assertEquals(before + 1, after);
	}

	@Test
	public void addElementWithoutPb() {
		User userBase = new User(null, "Jean", "Lamoule", new ArrayList<Product>());
        Long id = userService.save(userBase).getId();
        User userFetch = userRepository.getUserById(id);

        assertTrue(compare(userBase, userFetch));
	}

	@Test
	public void updateElementWithoutPb() {
		User userBase = new User(null, "Jean", "Lamoule", new ArrayList<Product>());

	}

	@Test
    public void getUserRight() {
        User userBase = new User(null , "Jean", "Lamoule", new ArrayList<Product>());
        Long id = userRepository.save(userBase).getId();
        User userFetch = userService.getUserById(id);

        assertTrue(compare(userBase, userFetch));
    }



	//autres méthodes
    public Boolean compare(User user1, User user2) {
        boolean result = true;

        if (!user1.getId().equals(user2.getId())) {
            result = false;
            System.out.println("id: " + user1.getId() + " " + user2.getId());
        }
        if (!user1.getFirstname().equals(user2.getFirstname())) {
            result = false;
            System.out.println("firstname: " + user1.getFirstname() + " " + user2.getFirstname());
        }
        if (!user1.getLastname().equals(user2.getLastname())) {
            result = false;
            System.out.println("lastname: " + user1.getLastname() + " " + user2.getLastname());
        }

        return result;
    }
}
