package ru.iteco.saorder.service.model;

import java.io.Serializable;

public interface Identified <ID extends Serializable> extends Serializable{
    ID getId();
}
