package org.example.pojoClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerBoard{
    public String status;
    public int disableAt;
    public int warnAt;
}