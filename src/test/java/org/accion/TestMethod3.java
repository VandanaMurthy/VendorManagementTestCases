package org.accion;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.accion.controller.VendorController;
import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)

//Unit Testing with @WebMvcTest(With Mock objects)
public class TestMethod3 {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VendorService vendorService;

	@Test
	public void givenVendors_whenGetVendors_thenReturnJsonArray()
	  throws Exception {
	     
	    Vendor vendor = new Vendor(3000,"Rackspace","Produts");
	 
	    List<Vendor> allVendors = Arrays.asList(vendor);
	 
	    when(vendorService.findAll()).thenReturn(allVendors);
	 
	    mvc.perform(get("/allVendors")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].name", is(vendor.getName())));
	 
}
}
