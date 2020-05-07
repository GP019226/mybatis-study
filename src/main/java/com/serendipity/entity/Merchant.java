package com.serendipity.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Merchant {
    private Integer mid;

    private String name;

    private List<Integer> businessScope;

}