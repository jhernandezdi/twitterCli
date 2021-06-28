
//package com.sine95.tweetsrv.service.ln;
package com.sine95.tweetsrv.service.ln;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import com.sine95.tweetsrv.service.ln.ClienteTwitter.ClienteTwitter_InitCliLNServiceTest;
import com.sine95.tweetsrv.service.ln.ClienteTwitter.ClienteTwitter_SendTwitLNServiceTest;
import com.sine95.tweetsrv.service.ln.GestionTweets.GestionTweets_ValidarTweetLNServiceTest;
import com.sine95.tweetsrv.service.ln.GestionTweets.GestionTweets_TweetsValidosLNServiceTest;
import com.sine95.tweetsrv.service.ln.GestionTweets.GestionTweets_TweetsLNServiceTest;
import com.sine95.tweetsrv.service.ln.GestionTweets.GestionTweets_HashtagsMasUsadosLNServiceTest;

@RunWith(Suite.class)
@SuiteClasses({

	ClienteTwitter_InitCliLNServiceTest.class,
	ClienteTwitter_SendTwitLNServiceTest.class,
	GestionTweets_ValidarTweetLNServiceTest.class,
	GestionTweets_TweetsValidosLNServiceTest.class,
	GestionTweets_TweetsLNServiceTest.class,
	GestionTweets_HashtagsMasUsadosLNServiceTest.class
})
@SuppressWarnings("unused")
public class LNTestSuite {

}
// HASTA AQUI TPL: JavaTestSuite

