package examples.AllCodeSnippets; 
public static final class class_468 extends Provider {
private static final long serialVersionUID = 1L;

public OAuth2Provider() {
  super("Google OAuth2 Provider", 1.0,
        "Provides the XOAUTH2 SASL Mechanism");
  put("SaslClientFactory.XOAUTH2",
      "com.example.testjavamail.OAuth2SaslClientFactory");
}
