package Advanced.S.member;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(//HttpServletRequest httpServletRequest, // HttpServletRequest 객체로 헤더 정보 얻기
                                     @RequestHeader("user-agent") String userAgent, // 개별 헤더 얻기
                                     // @RequestHeader Map<String, String> headers,// 전체 헤더 정보 얻기
                                     @RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone) {
        Map<String, String> memberMap = new LinkedHashMap<>();
        memberMap.put("email", email);
        memberMap.put("name",name);
        memberMap.put("phone",phone);

        // 개별 헤더 정보 출력
        System.out.println("user-agent : " + userAgent);
        // 전체 헤더 정보 연속 출력
//        for (Map.Entry<String, String> entry : headers.entrySet()) {
//            System.out.println("key: " + entry.getKey() +
//                    ", value: " + entry.getValue());
//        }
        // HttpServletRequest 객체로 얻기
//        System.out.println("user-agent : " + httpServletRequest.getHeader("user-agent"));

        return new ResponseEntity<>(memberMap,
                HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getCoffees(HttpEntity httpEntity) {
        for(Map.Entry<String, List<String>> entry : httpEntity.getHeaders().entrySet()){
            System.out.println("key: " + entry.getKey()
                    + ", " + "value: " + entry.getValue());
        }

        System.out.println("host: " + httpEntity.getHeaders().getHost());
        return null;
    }
}