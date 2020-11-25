package examples.AllCodeSnippets; 
public class class_685 extends FilterOutputStream {

    private final Mac mac;

    public MacOutputStream(OutputStream out, Mac mac) {
        super(out);
        this.mac = mac;
    }

    @Override
    public void write(byte[] b) throws IOException {
        mac.update(b);
        out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        mac.update((byte) b);
        out.write(b);
    }

    public byte[] getMac() {
        return mac.doFinal();
    }
}
