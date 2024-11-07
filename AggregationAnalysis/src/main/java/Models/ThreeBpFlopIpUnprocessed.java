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
    @Column(name="FLOP_ID")
    private String flopId;
    @Column(name="FLOP")
    private String flop;
    @Column(name="HAND")
    private String hand;
    @Column(name="WEIGHT")
    private BigDecimal weight;
    @Column(name="MATCHUPS")
    private BigDecimal matchups;
    @Column(name="IP_EQUITY")
    private BigDecimal ipEquity;
    @Column(name="IP_EV")
    private BigDecimal ipEv;
    @Column(name="IP_EQR")
    private BigDecimal ipEqr;
    @Column(name="SIZE_ONE_FREQ")
    private BigDecimal SizeOneFreq;
    @Column(name="SIZE_ONE_AMOUNT")
    private BigDecimal SizeOneAmount;
    @Column(name="SIZE_ONE_EV")
    private BigDecimal SizeOneEv;
    @Column(name="SIZE_TWO_FREQ")
    private BigDecimal SizeTwoFreq;
    @Column(name="SIZE_TWO_AMOUNT")
    private BigDecimal SizeTwoAmount;
    @Column(name="SIZE_TWO_EV")
    private BigDecimal SizeTwoEv;
    @Column(name="SIZE_THREE_FREQ")
    private BigDecimal SizeThreeFreq;
    @Column(name="SIZE_THREE_AMOUNT")
    private BigDecimal SizeThreeAmount;
    @Column(name="SIZE_THREE_EV")
    private BigDecimal SizeThreeEv;
    @Column(name="SIZE_FOUR_FREQ")
    private BigDecimal SizeFourFreq;
    @Column(name="SIZE_FOUR_AMOUNT")
    private BigDecimal SizeFourAmount;
    @Column(name="SIZE_FOUR_EV")
    private BigDecimal SizeFourEv;
    @Column(name="SIZE_FIVE_FREQ")
    private BigDecimal SizeFiveFreq;
    @Column(name="SIZE_FIVE_AMOUNT")
    private BigDecimal SizeFiveAmount;
    @Column(name="SIZE_FIVE_EV")
    private BigDecimal SizeFiveEv;
    @Column(name="SIZE_SIX_FREQ")
    private BigDecimal SizeSixFreq;
    @Column(name="SIZE_SIX_AMOUNT")
    private BigDecimal SizeSixAmount;
    @Column(name="SIZE_SIX_EV")
    private BigDecimal SizeSixEv;
    @Column(name="SIZE_SEVEN_FREQ")
    private BigDecimal SizeSevenFreq;
    @Column(name="SIZE_SEVEN_AMOUNT")
    private BigDecimal SizeSevenAmount;
    @Column(name="SIZE_SEVEN_EV")
    private BigDecimal SizeSevenEv;
    @Column(name="SIZE_EIGHT_FREQ")
    private BigDecimal SizeEightFreq;
    @Column(name="SIZE_EIGHT_AMOUNT")
    private BigDecimal SizeEightAmount;
    @Column(name="SIZE_EIGHT_EV")
    private BigDecimal SizeEightEv;
    @Column(name="SIZE_NINE_FREQ")
    private BigDecimal SizeNineFreq;
    @Column(name="SIZE_NINE_AMOUNT")
    private BigDecimal SizeNineAmount;
    @Column(name="SIZE_NINE_EV")
    private BigDecimal SizeNineEv;
    @Column(name="SIZE_TEN_FREQ")
    private BigDecimal SizeTenFreq;
    @Column(name="SIZE_TEN_AMOUNT")
    private BigDecimal SizeTenAmount;
    @Column(name="SIZE_TEN_EV")
    private BigDecimal SizeTenEv;
    @Column(name="CHECK_FREQ")
    private BigDecimal checkFreq;
    @Column(name="CHECK_EV")
    private BigDecimal checkEv;
    @Column(name="DEEPNESS")
    private Integer deepness;
}
