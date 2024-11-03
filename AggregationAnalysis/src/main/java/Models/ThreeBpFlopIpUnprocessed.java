package Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="3bp_ip_flop")
@Data
public class ThreeBpFlopIpUnprocessed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String flopId;

    private String flop;
    private String hand;
    private BigDecimal weight;
    private BigDecimal matchups;
    private BigDecimal ipEquity;
    private BigDecimal ipEv;
    private BigDecimal ipEqr;
    private BigDecimal bet1101Freq;
    private BigDecimal bet1101Ev;
    private BigDecimal bet875Freq;
    private BigDecimal bet875Ev;
    private BigDecimal bet438Freq;
    private BigDecimal bet438Ev;
    private BigDecimal checkFreq;
    private BigDecimal checkEv;
}
