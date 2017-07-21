package org.accion;

import static org.assertj.core.api.Assertions.assertThat;

import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.accion.service.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

//Unit Testing with @MockBean
public class TestMethod2 extends  VendorManagementApplicationTests{
	
	@TestConfiguration
    static class VendorServiceImplTestContextConfiguration {
  
        @Bean
        public VendorService vendorService() {
            return new VendorService();
        }
    }
	@Autowired
	private VendorService vendorService;
	
	@MockBean
	private VendorRepository vendorRepository;
	@Before
	public void setUp() {
	    Vendor vendor = new Vendor(3000,"MSA","Data Sources");
	 
	    Mockito.when(vendorRepository.findByName(vendor.getName()))
	      .thenReturn(vendor);
	}
	@Test
	public void whenValidName_thenVendor() {
	    String expected = "MSA";
	    Vendor ven = vendorService.findVendorByName(expected);
	  
	     assertThat(ven.getName())
	      .isEqualTo(expected);
	 }

}
