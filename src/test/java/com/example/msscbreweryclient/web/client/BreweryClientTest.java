package com.example.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import com.example.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void testSaveNewBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
    URI uri = client.saveNewBeer(beerDto);
    assertNotNull(uri);
    System.out.println(uri.toString());
  }

  @Test
  void testUpdateBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
    client.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  void testDeleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }

  @Test
  void testGetCustomerById() {
    CustomerDto dto = client.getCustomerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void testSaveNewCustomer() {
    CustomerDto customerDto = CustomerDto.builder().name("Leo").build();
    URI uri = client.saveNewCustomer(customerDto);
    assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void testUpdateCustomer() {
    CustomerDto customerDto = CustomerDto.builder().name("Sbo").build();
    client.updateCustomer(UUID.randomUUID(), customerDto);
  }

  @Test
  void testDeleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());
  }
}
