
package com.juanma.twitterCli;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

	com.juanma.twitterCli.service.ln.LNTestSuite.class
})
@SuppressWarnings("unused")
public class TwitterCliTestSuite {

}
