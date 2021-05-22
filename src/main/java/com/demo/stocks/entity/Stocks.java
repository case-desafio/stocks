package com.demo.stocks.entity;

import com.demo.stocks.util.StringUtils;

import java.util.Objects;

public class Stocks {
    private String symbol;
    private Double change;
    private Double closingPrice;
    private Double eps;
    private Double high;
    private Double lastPrice;
    private Double lastYearHigh;
    private Double lastYearLow;
    private Double low;
    private Long marketCap;
    private String name;
    private Double priceOpen;
    private Long shares;
    private Long volume;
    private Long volumeAvg;
    private String sector;
    private String subSector;
    private String segment;

    @Override
    public String toString() {
        return "Quote{" +
                "  name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", change=" + change +
                ", lastPrice=" + lastPrice +
                '}';
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getLastYearHigh() {
        return lastYearHigh;
    }

    public void setLastYearHigh(Double lastYearHigh) {
        this.lastYearHigh = lastYearHigh;
    }

    public Double getLastYearLow() {
        return lastYearLow;
    }

    public void setLastYearLow(Double lastYearLow) {
        this.lastYearLow = lastYearLow;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceOpen() {
        return priceOpen;
    }

    public void setPriceOpen(Double priceOpen) {
        this.priceOpen = priceOpen;
    }

    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getVolumeAvg() {
        return volumeAvg;
    }

    public void setVolumeAvg(Long volumeAvg) {
        this.volumeAvg = volumeAvg;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSubSector() {
        return subSector;
    }

    public void setSubSector(String subSector) {
        this.subSector = subSector;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stocks stocks = (Stocks) o;
        return Objects.equals(symbol, stocks.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(symbol);
    }
}
