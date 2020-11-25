package examples.AllCodeSnippets; 
public class class_558 {

    private static ECPublicKey decodeECPublicKey(ECParameterSpec params,
            final byte[] pubkey) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        int keySizeBytes = params.getOrder().bitLength() / Byte.SIZE;

        int offset = 0;
        BigInteger x = new BigInteger(1, Arrays.copyOfRange(pubkey, offset,
                offset + keySizeBytes));
        offset += keySizeBytes;
        BigInteger y = new BigInteger(1, Arrays.copyOfRange(pubkey, offset,
                offset + keySizeBytes));
        ECPoint w = new ECPoint(x, y);

        ECPublicKeySpec otherKeySpec = new ECPublicKeySpec(w, params);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECPublicKey otherKey = (ECPublicKey) keyFactory
                .generatePublic(otherKeySpec);
        return otherKey;
    }

    private static byte[] encodeECPublicKey(ECPublicKey pubKey) {
        int keyLengthBytes = pubKey.getParams().getOrder().bitLength()
                / Byte.SIZE;
        byte[] publicKeyEncoded = new byte[2 * keyLengthBytes];

        int offset = 0;

        BigInteger x = pubKey.getW().getAffineX();
        byte[] xba = x.toByteArray();
        if (xba.length > keyLengthBytes + 1 || xba.length == keyLengthBytes + 1
                && xba[0] != 0) {
            throw new IllegalStateException(
                    "X coordinate of EC public key has wrong size");
        }

        if (xba.length == keyLengthBytes + 1) {
            System.arraycopy(xba, 1, publicKeyEncoded, offset, keyLengthBytes);
        } else {
            System.arraycopy(xba, 0, publicKeyEncoded, offset + keyLengthBytes
                    - xba.length, xba.length);
        }
        offset += keyLengthBytes;

        BigInteger y = pubKey.getW().getAffineY();
        byte[] yba = y.toByteArray();
        if (yba.length > keyLengthBytes + 1 || yba.length == keyLengthBytes + 1
                && yba[0] != 0) {
            throw new IllegalStateException(
                    "Y coordinate of EC public key has wrong size");
        }

        if (yba.length == keyLengthBytes + 1) {
            System.arraycopy(yba, 1, publicKeyEncoded, offset, keyLengthBytes);
        } else {
            System.arraycopy(yba, 0, publicKeyEncoded, offset + keyLengthBytes
                    - yba.length, yba.length);
        }

        return publicKeyEncoded;
    }

    public static void main(String[] args) throws Exception {

        // (only) required for named curves other than those used in JCE
        Security.addProvider(new BouncyCastleProvider());

        // create local and remote key
        KeyPairGenerator kpgen = KeyPairGenerator.getInstance("ECDH", "BC");
        ECGenParameterSpec genspec = new ECGenParameterSpec("brainpoolp256r1");
        kpgen.initialize(genspec);
        KeyPair localKeyPair = kpgen.generateKeyPair();
        KeyPair remoteKeyPair = kpgen.generateKeyPair();

        // test generation
        byte[] encodedRemotePublicKey = encodeECPublicKey((ECPublicKey) remoteKeyPair
                .getPublic());
        // test creation
        ECPublicKey remoteKey = decodeECPublicKey(
                ((ECPublicKey) localKeyPair.getPublic()).getParams(),
                encodedRemotePublicKey);

        // local key agreement
        KeyAgreement localKA = KeyAgreement.getInstance("ECDH");
        localKA.init(localKeyPair.getPrivate());
        localKA.doPhase(remoteKey, true);
        byte[] localSecret = localKA.generateSecret();

        // remote key agreement
        KeyAgreement remoteKA = KeyAgreement.getInstance("ECDH");
        remoteKA.init(remoteKeyPair.getPrivate());
        remoteKA.doPhase((ECPublicKey) localKeyPair.getPublic(), true);
        byte[] remoteSecret = localKA.generateSecret();

        // validation
        System.out.println(Arrays.equals(localSecret, remoteSecret));
    }
}
