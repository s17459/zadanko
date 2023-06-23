package pl.pjatk.edu.Jaz17459NbpApplication.controller;

import pl.pjatk.edu.Jaz17459NbpApplication.entity.MidCurrencyHistory;
import pl.pjatk.edu.Jaz17459NbpApplication.entity.Root;
import pl.pjatk.edu.Jaz17459NbpApplication.service.RateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NbpRestController {

    private final RateService rateService;

    public NbpRestController(RateService rateService) {
        this.rateService = rateService;
    }

    @ApiOperation(value = "get currency price form NBP API",
            response = Root.class,
            notes = "This method get average price from any days, and insert data to database. If not found give 404. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "404 NotFound"),
            @ApiResponse(code = 400, message = "400 Bad Request")
    })
    @GetMapping("/{currency}")
    public ResponseEntity<MidCurrencyHistory> getPriceFromDays(
            @ApiParam(name = "currency",
                    value = "Currency code(usd)",
                    required = true,
                    type = "String")
            @PathVariable String currency,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(rateService.getPrice(currency, startDate, endDate));
    }

}
