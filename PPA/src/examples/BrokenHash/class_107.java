package examples.BrokenHash;

public class class_107 {
	public static String getHash() {
		MessageDigest md = MessageDigest.getInstance("MD5");
		try (InputStream is = Files.newInputStream(Paths.get("file.txt"))) {
		  DigestInputStream dis = new DigestInputStream(is, md);
		  /* Read stream to EOF as normal... */
		}
		catch (Exception ex) {
			byte[] digest = md.digest();
		}
	}
}