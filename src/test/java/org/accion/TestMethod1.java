package org.accion;

import static org.assertj.core.api.Assertions.assertThat;
import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

//Integration Testing with @DataJpaTest
//Testing persistence Layer
@DataJpaTest
public class TestMethod1 extends  VendorManagementApplicationTests{

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	
	@Test
	public void whenFindByName_thenReturnVendor(){
		Vendor v1=new Vendor(2500,"Panasonic","Accessories");
		entityManager.persist(v1);
		entityManager.flush();
		
		Vendor expected=vendorRepository.findByName(v1.getName());
		assertThat(expected.getName()).isEqualTo(v1.getName());
		
	}
}
