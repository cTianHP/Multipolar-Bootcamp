package com.multipolar.bootcamp.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipolar.bootcamp.gateway.dto.AccountDTO;
import com.multipolar.bootcamp.gateway.dto.CustomerDTO;
import com.multipolar.bootcamp.gateway.dto.ErrorMessageDTO;
import com.multipolar.bootcamp.gateway.dto.ProductDTO;
import com.multipolar.bootcamp.gateway.kafka.AccessLog;
import com.multipolar.bootcamp.gateway.service.AccessLogService;
import com.multipolar.bootcamp.gateway.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final String CUSTOMER_URL = "http://localhost:8081/customer";
    private static final String PRODUCT_URL = "http://localhost:8083/product";

    private static final String ACCOUNT_URL = "http://localhost:8084/account";
    private final RestTemplateUtil restTemplateUtil;
    private final ObjectMapper objectMapper;
    private final AccessLogService logService;

    @Autowired
    public ApiController(RestTemplateUtil restTemplateUtil, ObjectMapper objectMapper, AccessLogService logService) {
        this.restTemplateUtil = restTemplateUtil;
        this.objectMapper = objectMapper;
        this.logService = logService;
    }

    /*
    @GetMapping("/getCustomers")
    public ResponseEntity<?> getCustomers() throws JsonProcessingException {
        //akses API customer dan dapatkan datanya
        try{
            ResponseEntity<?> response =restTemplateUtil.getList(CUSTOMER_URL, new ParameterizedTypeReference<Object>() {});
            ResponseEntity.status(response.getStatusCode()).body(response.getBody());
            //kirim AccessLog
            //AccessLog accessLog = new AccessLog("GET",response.getStatusCode().toString(), "successful");
            AccessLog accessLog = new AccessLog("GET", CUSTOMER_URL, response.getStatusCodeValue(), LocalDateTime.now(),
                    "Successful");
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(),List.class);
            //AccessLog accessLog = new AccessLog("GET",ex.getStatusCode().toString(),"failed");
            AccessLog accessLog = new AccessLog("GET", PRODUCT_URL, 400, LocalDateTime.now(),
                    "Failed");
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
     */

    /*
    //http://localhost:8080/api/createCustomer
    @PostMapping("/createCustomer")
    public ResponseEntity<?> postCustomer(@RequestBody CustomerDTO customerDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(CUSTOMER_URL, customerDTO, CustomerDTO.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
     */

    /*
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts() throws JsonProcessingException {
        //akses API product dan dapatkan datanya
        try{
            ResponseEntity<?> response =restTemplateUtil.getList(PRODUCT_URL, new ParameterizedTypeReference<Object>() {});
            ResponseEntity.status(response.getStatusCode()).body(response.getBody());
            //kirim AccessLog
            AccessLog accessLog = new AccessLog("GET", PRODUCT_URL, response.getStatusCodeValue(), LocalDateTime.now(),
                    "Successful");
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(),List.class);
            AccessLog accessLog = new AccessLog("GET", PRODUCT_URL,ex.getRawStatusCode(), LocalDateTime.now(),
                    "failed");

            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
     */
    //http://localhost:8080/api/createCustomer
    /*@PostMapping("/createProduct")
    public ResponseEntity<?> postProduct(@RequestBody ProductDTO productDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(PRODUCT_URL, productDTO, ProductDTO.class);
            AccessLog accessLog = new AccessLog("POST", PRODUCT_URL+"/createProduct", response.getStatusCodeValue(), LocalDateTime.now(),
                    "Successful");
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("POST", PRODUCT_URL,ex.getRawStatusCode(), LocalDateTime.now(),
                    "failed");

            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
     */
    @GetMapping("/getAccount")
    public ResponseEntity<?> getAccount(HttpServletRequest request) throws JsonProcessingException {
        String clientIp = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        try {
            ResponseEntity<?> response = restTemplateUtil.getList(ACCOUNT_URL,
                    new ParameterizedTypeReference<Object>() {
                    });
            ResponseEntity.status(response.getStatusCode()).body(response.getBody());


            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL + "/getAccount",
                    response.getStatusCodeValue(), "Success", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL + "/getAccount",
                    ex.getRawStatusCode(),"Failed",clientIp, userAgent,LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<?> getBankAccountById(@PathVariable String id, HttpServletRequest request)
            throws JsonProcessingException {
        String clientIp = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try {
            ResponseEntity<?> response = restTemplateUtil.get(ACCOUNT_URL + "/" + id, AccountDTO.class);
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL + "getaccount",
                    response.getStatusCodeValue(), "Success", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL + "/getaccount",
                    ex.getRawStatusCode(), "Failed", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

    @PostMapping("/createAccount")
    public ResponseEntity<?> postAccount(HttpServletRequest request) throws JsonProcessingException {
        String clientIp = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        try {
            ResponseEntity<?> response = restTemplateUtil.getList(ACCOUNT_URL,
                    new ParameterizedTypeReference<Object>() {
                    });
            ResponseEntity.status(response.getStatusCode()).body(response.getBody());


            AccessLog accessLog = new AccessLog("POST", ACCOUNT_URL + "/postAccount",
                    response.getStatusCodeValue(), "Success", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("POST", ACCOUNT_URL + "/postAccount",
                    ex.getRawStatusCode(),"Failed",clientIp, userAgent,LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<?> updateBankAccount(@PathVariable String id, @RequestBody AccountDTO accountDTO,
                                               HttpServletRequest request)
            throws JsonProcessingException {
        String clientIp = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try {
            ResponseEntity<?> response = restTemplateUtil.put(ACCOUNT_URL + "/" + id, accountDTO,
                    AccountDTO.class);
            AccessLog accessLog = new AccessLog("PUT", ACCOUNT_URL + "updateaccount",
                    response.getStatusCodeValue(), "Success", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("PUT", ACCOUNT_URL + "/updateaccount",
                    ex.getRawStatusCode(), "Failed", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable String id,HttpServletRequest request)
            throws JsonProcessingException {
        // akses API Customer dan hapus data
        String clientIp = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try {
            restTemplateUtil.delete(ACCOUNT_URL + "/" + id);
            AccessLog accessLog = new AccessLog("DELETE", ACCOUNT_URL + "/deleteAccount",
                    HttpStatus.OK.value(), "Success", clientIp, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("DELETE", ACCOUNT_URL + "/deleteAccount",
                    ex.getRawStatusCode(),"Failed",clientIp, userAgent,LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }


    /*
    //http://localhost:8080/api/createCustomer
    @PostMapping("/createProduct")
    public ResponseEntity<?> postAccount(@RequestBody ProductDTO productDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(PRODUCT_URL, productDTO, ProductDTO.class);
            AccessLog accessLog = new AccessLog("POST", PRODUCT_URL+"/createProduct", response.getStatusCodeValue(), LocalDateTime.now(),
                    "Successful");
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("POST", PRODUCT_URL,ex.getRawStatusCode(), LocalDateTime.now(),
                    "failed");

            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
     */
}

