package examples.AllCodeSnippets; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.Base64;

import de.measite.smack.Sasl;

public class class_1279 extends SASLMechanism
{
    static final String AUTHENTICATOR_URL = "http://www.google.com/talk/protocol/auth";
    protected String authenticationText = null;
    static final String TAG = "SASLXOAuth2Mechanism";

    public SASLXOAuth2Mechanism(SASLAuthentication saslAuthentication) {
        super(saslAuthentication);
    }

    @Override
    protected String getName()
    {
        return "X-OAUTH2";
    }

    @Override
    public void authenticate(String username, String host, String password) throws IOException, XMPPException {
        this.password = password;
        this.authenticationId = username;

        StringBuilder credentials = new StringBuilder();
        credentials.append("\0");
        credentials.append(username);
        credentials.append("\0");
        credentials.append(password);
        authenticationText = Base64.encodeBytes(credentials.toString().getBytes("UTF-8"), Base64.DONT_BREAK_LINES);

        String[] mechanisms = { "PLAIN" };
        Map<String,String> props = new HashMap<String,String>();
        sc = Sasl.createSaslClient(mechanisms, username, "xmpp", host, props, this);
        authenticate();
    }

    protected void authenticate() throws IOException, XMPPException {
        // Send the authentication to the server
        getSASLAuthentication().send(new XOAuth2AuthMechanism(getName(), authenticationText));
    }

    /**
     * Initiating SASL authentication by select a mechanism.
     */
    public class class_1279 extends Packet {
        final private String name;
        final private String authenticationText;

        public XOAuth2AuthMechanism(String name, String authenticationText) {
            super();
            this.name = name;
            this.authenticationText = authenticationText;
        }

        public String toXML() {
            StringBuilder stanza = new StringBuilder();
            stanza.append("<auth mechanism=\").append(name);
            stanza.append("\" xmlns=\"urn:ietf:params:xml:ns:xmpp-sasl\" auth:service=\"oauth2\" xmlns:auth=\").append(AUTHENTICATOR_URL);
            stanza.append("\">");
            if (authenticationText != null) {
                stanza.append(authenticationText);
            }
            stanza.append("</auth>");
            return stanza.toString();
        }
    }
}
