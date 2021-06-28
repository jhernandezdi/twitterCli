
//package com.juanma.twitterCli.service.ln;
package com.juanma.twitterCli.service.ln;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.juanma.twitterCli.service.ln.GestionTweets.GestionTweets_HashtagsMasUsadosLNServiceTest;
import com.juanma.twitterCli.service.ln.GestionTweets.GestionTweets_TweetsLNServiceTest;
import com.juanma.twitterCli.service.ln.GestionTweets.GestionTweets_TweetsValidosLNServiceTest;
import com.juanma.twitterCli.service.ln.GestionTweets.GestionTweets_ValidarTweetLNServiceTest;

@RunWith(Suite.class)
@SuiteClasses({

	GestionTweets_ValidarTweetLNServiceTest.class,
	GestionTweets_TweetsValidosLNServiceTest.class,
	GestionTweets_TweetsLNServiceTest.class,
	GestionTweets_HashtagsMasUsadosLNServiceTest.class
})
@SuppressWarnings("unused")
public class LNTestSuite {

}
// HASTA AQUI TPL: JavaTestSuite

