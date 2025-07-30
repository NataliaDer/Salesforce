package dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Account {
        private String name;
        private String phone;
        @Builder.Default
        private String fax = null;
        private String account_number;
        private String website;
        private String account_site;
        private String ticker_symbol;
        private String employees;
        private String annual_revenue;
        private String Sic_code;
        private String billing_street;
        private String shipping_street;
        private String rating;
        private String type;
        private String industry;
        private String ownership;
        private String CheckVip;
        private String checkTech;
    }