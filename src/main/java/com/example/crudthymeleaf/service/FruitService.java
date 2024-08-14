package com.example.crudthymeleaf.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.crudthymeleaf.model.Fruit;

import java.util.Arrays;
import java.util.List;

@Service
public class FruitService {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiUrl = "http://localhost:8080/api";

    public List<Fruit> getAllFruits() {
        String url = apiUrl + "/fruits";
        ResponseEntity<Fruit[]> response = restTemplate.getForEntity(url, Fruit[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(response.getBody());
        } else {
            throw new RuntimeException("Failed to fetch fruits");
        }
    }


    // Mengambil data buah berdasarkan ID
    public Fruit getFruitById(int id) {
        String endpoint = apiUrl + "/findById";
        String url = endpoint + "?id=" + id;
        ResponseEntity<Fruit> response = restTemplate.getForEntity(url, Fruit.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Fruit Not Found!");
        }
    }

    public void createFruit(Fruit fruit) {
        String url = apiUrl + "/fruits";
        try {
            restTemplate.postForEntity(url, fruit, Void.class);
        } catch (Error error) {
            throw new RuntimeException("Failed to post data!");
        }
    }

    public void updateFruit(int id, Fruit fruit) {
        String url = apiUrl + "/fruits?id=" + id;
        restTemplate.put(url, fruit);
    }

    public void deleteFruit(int id) {
        String url = apiUrl + "/fruits?id=" + id;
        restTemplate.delete(url);
    }

}

