package com.wyh.p2p.generator.entities;

public class P2pProduct {
    private Integer id;

    private Double lowestMoney;

    private Float rate;

    private Byte state;

    private Integer timeline;

    private String title;

    private Double allMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLowestMoney() {
        return lowestMoney;
    }

    public void setLowestMoney(Double lowestMoney) {
        this.lowestMoney = lowestMoney;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getTimeline() {
        return timeline;
    }

    public void setTimeline(Integer timeline) {
        this.timeline = timeline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }
}