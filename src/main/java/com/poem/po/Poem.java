package com.poem.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poem {
    private int id;
    private String name;
    private String context;
    private int authority_id;
    private int dynasty_id;
}
