package examples.AllCodeSnippets; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.security.sasl.Sasl;

import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.Base64;

public class class_1126 extends SASLMechanism {
    private static final Logger log = Logger.getLogger(SALSGTalkOauthMechanism.class.getName());
    public static final String NAME = "X-OAUTH2";


    /**
     * Constructor.
     */
    public SALSGTalkOauthMechanism(SASLAuthentication saslAuthentication) {
            super(saslAuthentication);
            log.info("Creating SASL mechanism for GTalk (X-OAUTH2)");
    }

    @Override
    public void authenticate(String username, String host, String accessToken) throws IOException, XMPPException {
        this.hostname = host;

        log.info("Authenticating to host "+host+" with key "+username);

        String[] mechanisms = { "X-OAUTH2" };
        Map<String, String> props = new HashMap<String, String>();
        this.sc = Sasl.createSaslClient(mechanisms, null, "xmpp", host, props, this);
        getSASLAuthentication().send(new AuthMechanism(getName(), Base64.encodeBytes(('\0'+username+'\0'+accessToken).getBytes())));
    }

    @Override
    protected String getName() {
            return NAME;
    }

     }
