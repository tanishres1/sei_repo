package controller;

import dto.PortfolioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PortfolioService;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public List<PortfolioDto>  getAllPortfolios(){
        return null;
    }

    @GetMapping("/{id}")
    public PortfolioDto getPortfolioById(@PathVariable Long id){
        return portfolioService.getPortfolioId(id);
    }

    @PostMapping
    public PortfolioDto createPortfolio(@RequestBody PortfolioDto dto){
        return portfolioService.createPortfolio(dto);

    }
    @DeleteMapping("/{id}")
    public  void  deletePortfolio(@PathVariable Long id){
        portfolioService.deletePortfolio(id);

    }

    @GetMapping("/client/{clientId}")
    public List<PortfolioDto> getPortfolioByClinetId(@PathVariable Long id){
     return   portfolioService.getPortfoliosByClientId(id);
    }


}
