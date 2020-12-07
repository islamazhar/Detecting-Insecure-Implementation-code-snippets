package examples.RSA; 
public class class_634 { 
Calendar calendarValidityStart = Calendar.getInstance();

Calendar calendarValidityEnd = Calendar.getInstance();
calendarValidityEnd.add(Calendar.YEAR, 99);

KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(context)
        .setAlias("MyKeyAlias")
        .setSubject(new X500Principal("CN=" + "MyKeyAlias"))
        .setSerialNumber(BigInteger.valueOf(1337))
        .setStartDate(calendarValidityStart.getTime())
        .setEndDate(calendarValidityEnd.getTime())
        .build();

KeyPairGenerator kpGenerator = KeyPairGenerator.getInstance(
        "RSA",
        "AndroidKeyStore");

kpGenerator.initialize(spec);

KeyPair keyPair = kpGenerator.generateKeyPair();

}