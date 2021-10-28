package org.example.guice.module;

import com.google.inject.AbstractModule;
import org.example.common.Address;
import org.example.guice.EmailAddress;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Address.class).to(EmailAddress.class);
    }

}
