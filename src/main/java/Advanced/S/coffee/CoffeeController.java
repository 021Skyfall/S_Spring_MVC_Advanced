package Advanced.S.coffee;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/coffees")
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("name") String name,
                                     @RequestParam("price") int price) {
        Map<String, Object> coffeeMap = new LinkedHashMap<>();
        coffeeMap.put("name", name);
        coffeeMap.put("price", price);

        // 헤더에 위치 정보 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-Geo-Location","Korea,Seoul");

        return new ResponseEntity<>(coffeeMap, headers,HttpStatus.CREATED);
    }
}