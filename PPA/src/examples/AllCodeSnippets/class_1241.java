package examples.AllCodeSnippets; 
@Configuration
public class class_1241 {

@Value("${gcm.senderID}")
private String username;

@Value("${gcm.apiKey}")
private String password;

@Value("${gcm.host}")
private String host;

@Value("${gcm.port}")
private int port;

@Bean(name="gcmConnection")
public XmppConnectionFactoryBean xmppConnectionFactoryBean(){

    ConnectionConfiguration configuration = new    ConnectionConfiguration(host, port);
    configuration.setSecurityMode(SecurityMode.enabled);
    configuration.setReconnectionAllowed(true);
    configuration.setRosterLoadedAtLogin(false);
    configuration.setSendPresence(false);
    configuration.setSocketFactory(SSLSocketFactory.getDefault());

//      configuration.setDebuggerEnabled(true);
    XmppConnectionFactoryBean connectionFactoryBean = new XmppConnectionFactoryBean(configuration);

    connectionFactoryBean.setUser(username);
    connectionFactoryBean.setPassword(password);

    return connectionFactoryBean;
}
}
