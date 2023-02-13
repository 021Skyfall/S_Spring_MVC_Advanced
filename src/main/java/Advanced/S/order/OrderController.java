package Advanced.S.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/v1/orders")
public class OrderController {
    @GetMapping
    public ResponseEntity getOrder(HttpServletResponse response) {
        response.addHeader("Client-Geo-Location", "Korea,Seoul");
        return null;
    }
}
