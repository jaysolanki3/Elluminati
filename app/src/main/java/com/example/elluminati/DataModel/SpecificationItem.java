package com.example.elluminati.DataModel;

import java.util.Collections;
import java.util.List;

public class SpecificationItem {
    private String id;
    private List<String> name;
    private int price;
    private int sequence_number;
    private boolean is_default_selected;
    private String specification_group_id;
    private int unique_id;

    public SpecificationItem(String name, int price) {
        this.name = Collections.singletonList(name);
        this.price = price;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSequence_number() {
        return sequence_number;
    }

    public void setSequence_number(int sequence_number) {
        this.sequence_number = sequence_number;
    }

    public boolean isIs_default_selected() {
        return is_default_selected;
    }

    public void setIs_default_selected(boolean is_default_selected) {
        this.is_default_selected = is_default_selected;
    }

    public String getSpecification_group_id() {
        return specification_group_id;
    }

    public void setSpecification_group_id(String specification_group_id) {
        this.specification_group_id = specification_group_id;
    }

    public int getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(int unique_id) {
        this.unique_id = unique_id;
    }
}
