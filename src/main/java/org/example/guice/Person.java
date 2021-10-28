package org.example.guice;

import com.google.inject.Inject;
import org.example.common.Address;
import org.example.common.Phone;

public class Person {

    @Inject
    private Address address;

    @Inject
    private Phone phone;

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

}
