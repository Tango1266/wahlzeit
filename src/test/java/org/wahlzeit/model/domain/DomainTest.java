package org.wahlzeit.model.domain;

import org.junit.ClassRule;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class DomainTest {
    @ClassRule
    public static RuleChain ruleChain = RuleChain
            .outerRule(new RegisteredOfyEnvironmentProvider())
            .around(new LocalDatastoreServiceTestConfigProvider());
}
