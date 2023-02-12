package com.medical.api.application;

import com.medical.api.domain.valueObject.Address;

public interface AddressMerger {

    default void merge(Address main, Address updated) {

        main.setStreet(
            updated.getStreet() != null
            ? updated.getStreet()
            : main.getStreet()
        );

        main.setNeighborhood(
            updated.getNeighborhood() != null
            ? updated.getNeighborhood()
            : main.getNeighborhood()
        );

        main.setZipcode(
            updated.getZipcode() != null
            ? updated.getZipcode()
            : main.getZipcode()
        );

        main.setCity(
            updated.getCity() != null
            ? updated.getCity()
            : main.getCity()
        );

        main.setState(
            updated.getState() != null
            ? updated.getState()
            : main.getState()
        );

        main.setComplement(
            updated.getComplement() != null
            ? updated.getComplement()
            : main.getComplement()
        );
    }
}
