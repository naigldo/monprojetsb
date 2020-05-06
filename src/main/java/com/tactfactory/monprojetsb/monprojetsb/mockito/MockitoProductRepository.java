package com.tactfactory.monprojetsb.monprojetsb.mockito;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repository.ProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;

public class MockitoProductRepository {
	//1 objet par type d'�l�ment pouvant �tre retourn�
	private String stringReturn;
	private Product productReturn;
	private User userReturn;
	public ProductRepository productRepository;
	public UserRepository userRepository;

	//constructeur qui importe le repo + initialise les variables
	public MockitoProductRepository(ProductRepository pr) {
		Product productReturn = new Product();
	}

	public void init() {
		//configuration des �l�ments � retourner

		//d�finition mockito
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
