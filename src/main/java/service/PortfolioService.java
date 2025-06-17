package service;

import dto.PortfolioDto;
import model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PortfolioRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepo portfolioRepo;

    public List<PortfolioDto> getAllPorfolios() {
        return portfolioRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<PortfolioDto> getPortfoliosByClientId(Long clientId) {
        return portfolioRepo.findClientId(clientId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PortfolioDto getPortfolioId(Long id) {
        Portfolio portfolio = portfolioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        return convertToDto(portfolio);
    }

    public PortfolioDto createPortfolio(PortfolioDto portfolioDto) {
        Portfolio portfolio = Portfolio.builder()
                .portfolioName(portfolioDto.getPortfolioName())
                .clientId(portfolioDto.getClientId())
                .totalAmount(portfolioDto.getTotalAmount())
                .build();

        Portfolio saved = portfolioRepo.save(portfolio);
        return convertToDto(saved);
    }

    public void deletePortfolio(Long id) {
        portfolioRepo.deleteById(id);
    }

    // ✅ Reusable conversion method
    private PortfolioDto convertToDto(Portfolio portfolio) {
        return new PortfolioDto(
                portfolio.getId(),
                portfolio.getPortfolioName(),
                portfolio.getClientId(),
                portfolio.getTotalAmount()
        );
    }
}
