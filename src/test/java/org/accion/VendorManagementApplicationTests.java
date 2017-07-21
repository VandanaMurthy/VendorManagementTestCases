package org.accion;

import static org.assertj.core.api.Assertions.assertThat;

import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.accion.service.VendorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VendorManagementApplicationTests {
@Autowired
private TestEntityManager entityManager;

@Autowired
private VendorRepository vendorRepository;
	
	@Test
	//To test Persistence Layer
	public void whenFindByName_thenReturnVendor() {
	    // given
	    Vendor ven = new Vendor(1500,"Nature Baket","Food","Bangalore","15/04/2017","15/07/2017",25000.00,"ACTIVE");
	    entityManager.persist(ven);
	    entityManager.flush();
	 
	    // when
	    Vendor found =vendorRepository.findByName(ven.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(ven.getName());
	}
	@TestConfiguration
	static class VendorServiceImplTestContextConfiguration{
		@Bean
		public VendorService vendorService(){
			return new VendorServiceImpl();
		}
	}
}
