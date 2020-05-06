package com.tactfactory.monprojetsb.monprojetsb.mockito;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repository.ProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;

public class MockitoUserRepository {
	//1 objet par type d'élément pouvant être retourné
	private String stringReturn;
	private Product productReturn;
	private User userReturn;
	public ProductRepository productRepository;
	public UserRepository userRepository;

	//constructeur qui importe le repo + initialise les variables
	public MockitoUserRepository(UserRepository ur) {
		User userReturn = new User();
	}

	public void init() {
		//configuration des éléments à retourner

		//définition mockito
		Mockito.when(objetAMocker.fonction(params ...)).thenReturn(this.result);

		Mockito.when(objetAMocker.fonction(params ...)).thenAnswer(new Answer<objetAEnvoyer>() {
			@Override
			public objetAEnvoyer answer(InvocationOnMock invocation) throws Throwable {

				User user = invocation.getArgument(0);

				user.setId(1L);

				return MaClass.this.result ;

				}

			});
	}

}
