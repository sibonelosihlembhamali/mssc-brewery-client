package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

  public final String BEER_PATH_V1 = "/api/v1/beer/";
  public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
  private String apihost;

  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID beerId) {
    return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
  }

  public URI saveNewBeer(BeerDto beerDto) {
    return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
  }

  public void updateBeer(UUID beerId, BeerDto beerDto) {
    restTemplate.put(apihost + BEER_PATH_V1 + "/" + beerId.toString(), beerDto);
  }

  public void deleteBeer(UUID beerId) {
    restTemplate.delete(apihost + BEER_PATH_V1 + "/" + beerId);
  }

  public void setApihost(String apihost) {
    this.apihost = apihost;
  }

  public CustomerDto getCustomerById(UUID customerId) {
    return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId, CustomerDto.class);
  }

  public URI saveNewCustomer(CustomerDto customerDto) {
    return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
  }

  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + customerId, customerDto);
  }

  public void deleteCustomer(UUID customerId) {
    restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + customerId);
  }
}
