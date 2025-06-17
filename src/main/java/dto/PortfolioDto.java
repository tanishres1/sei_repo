package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDto {

    private long id;
    private String portfolioName;
    private long clientId;
    private double totalAmount;


}
