
package com.sine95.tweetsrv;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

	com.sine95.tweetsrv.service.ln.LNTestSuite.class
})
@SuppressWarnings("unused")
public class TweetsrvTestSuite {

}
